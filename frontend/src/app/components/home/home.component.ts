import {Component, OnInit, TemplateRef} from '@angular/core';
import {User} from "../../models/userModel";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {UserService} from "../../services/user.service";
import {Router} from "@angular/router";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {Post} from "../../models/postModel";
import {Subscription} from "rxjs";
import {PostService} from "../../services/post.service";
import {PhotoService} from "../../services/photo.service";
import {SubService} from "../../services/sub.service";
import {PostViewModel} from "../../models/postViewModel";
import {PostViewModelService} from "../../services/postViewModel.service";
import {UserViewModel} from "../../models/userViewModel";
import {UserViewModelService} from "../../services/userViewModel.service";
import {LikeService} from "../../services/like.service";
import {Like} from "../../models/likeModel";
import {PageModel} from "../../models/pageModel";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  currentFile: File;
  selectedFiles: FileList;
  public currentPage: number = 0;
  public userViewModel: UserViewModel;
  public user: User;
  public subscriptions: Subscription[] = [];
  public modalRef: BsModalRef;
  public pageModel: PageModel;
  public newPostViewModel: PostViewModel;

  public newText: string = "";

  constructor(private userService: UserService,
              private postService: PostService,
              private userViewModelService: UserViewModelService,
              private subService: SubService,
              private likeService: LikeService,
              private postViewModelService: PostViewModelService,
              private photoService: PhotoService,
              private modalService: BsModalService,
              private loadingService: Ng4LoadingSpinnerService,
              private router: Router,
  ) {
  }

  ngOnInit() {
    this.userService.checkGuest(this.router);
    let temp = JSON.parse(localStorage.getItem("currentUser"));
    const id = temp.idUser;
    this.loadYourPageInfo(id);
    this.loadPostViewModels(id, this.currentPage);
  }

  private loadYourPageInfo(id: number) {
    this.subscriptions.push(this.userViewModelService.getUserViewModel(id).subscribe(model => {
      this.userViewModel = model as UserViewModel;
      this.subscriptions.push(this.userService.getUserById(id).subscribe( account => {
        this.user = account as User;
        localStorage.clear();
        localStorage.setItem("currentUser", JSON.stringify(account as User));
      }));
    }))
  }

  private loadPostViewModels(id: number, pageNo: number): void {
    this.subscriptions.push(this.postViewModelService.getHomePageModel(id, pageNo, 4).subscribe(page => {
      this.pageModel = page as PageModel;
    }))
  }

  public dateToString(date: Date) : string {
    let temp = new Date(date);
    let month: number = temp.getMonth();
    return temp.getUTCDate() + "." + ++month + "." + temp.getFullYear();
  }

  private deleteAccount(): void {
    localStorage.clear();
    this.subscriptions.push(this.userService.deleteUser(this.userViewModel.idUser).subscribe(() => {
        this.router.navigate(['/login'], {});
    }));
  }

  private openModal(template: TemplateRef<any>): void {
    this.modalRef = this.modalService.show(template);
  }

  private likePost(postViewModel: PostViewModel): void {
    this.subscriptions.push(this.likeService.saveLike(new Like(this.user.idUser, postViewModel.post.idPost)).subscribe( ()=> {
      this.updateLikes(postViewModel);
    }));
  }

  private dislikePost(postViewModel: PostViewModel): void {
    this.subscriptions.push(this.likeService.deleteLike(postViewModel.like.idLike).subscribe( ()=> {
      this.updateLikes(postViewModel);
    }));
  }

  private deletePost(postviewModel: PostViewModel) : void {
    this.subscriptions.push(this.postService.deletePost(postviewModel.post.idPost).subscribe(() => {
      this.loadPostViewModels(this.user.idUser, this.currentPage);
      this.postService.countPosts(this.user.idUser).subscribe(amount => {
        this.userViewModel.numberOfPosts = amount as number;
      })
    }));
  }

  private updateLikes(postViewModel: PostViewModel): void {
    this.subscriptions.push(this.likeService.getLike(this.user.idUser, postViewModel.post.idPost).subscribe(like => {
      postViewModel.like = like as Like;
      this.likeService.countLikes(postViewModel.post.idPost).subscribe(amount => {
        postViewModel.likeCount = amount as number;
      });
    }));
  }

  private editUser(): void {
    this.uploadProfilePhoto();
    this.subscriptions.push(this.userService.saveUser(this.user).subscribe(() => {
      location.reload();
      }
    ));
    this.closeModal();
  }

  private saveNewPost(): void {
    this.currentFile = this.selectedFiles.item(0);
    this.photoService.uploadFile(this.currentFile).subscribe();
    this.newPostViewModel = new PostViewModel(this.user.idUser, new Post(this.newText, new Date(), this.user.idUser), this.currentFile.name);
    this.subscriptions.push(this.postViewModelService.savePostViewModel(this.newPostViewModel).subscribe(() => {
      this.loadPostViewModels(this.user.idUser, this.currentPage);
      this.postService.countPosts(this.user.idUser).subscribe(amount => {
        this.userViewModel.numberOfPosts = amount as number;
      })
    }));
    this.closeModal();
  }

  selectFile(event) {
    this.selectedFiles = event.target.files;
  }

  private closeModal(): void {
    this.newText = "";
    this.modalRef.hide();
  }

  private exit(): void {
    localStorage.clear();
    this.router.navigate(['/login'], {});
  }


  private uploadProfilePhoto(): void {
    if(this.selectedFiles != null) {
      this.currentFile = this.selectedFiles.item(0);
      this.user.profilePhoto = this.currentFile.name;
      this.userService.uploadProfilePhoto(this.currentFile).subscribe();
    }
  }
  pageChanged(event: any): void {
    this.loadPostViewModels(this.user.idUser, event.page - 1);let scrollToTop = window.setInterval(() => {
      let pos = window.pageYOffset;
      if (pos > 750) {
        window.scrollTo(0, pos - 200); // how far to scroll on each step
      } else {
        window.clearInterval(scrollToTop);
      }
    }, 16);
    this.currentPage = event.page - 1;
  }
}
