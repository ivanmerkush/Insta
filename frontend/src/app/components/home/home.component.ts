import {Component, OnInit, TemplateRef} from '@angular/core';
import {User} from "../../models/userModel";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {UserService} from "../../services/user.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {Post} from "../../models/postModel";
import {Photo} from "../../models/photoModel";
import {PostPhotoLike} from "../../models/postPhotoLike";
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

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  currentFile: File;
  selectedFiles: FileList;
  public userViewModel: UserViewModel;
  public user: User;
  public posts: PostViewModel[] = [];
  public subscriptions: Subscription[] = [];
  public modalRef: BsModalRef;

  public newPostViewModel: PostViewModel;

  public newPost: Post;
  public newText: string;
  public newPhotoPath: string;

  constructor(private userService: UserService,
              private postService: PostService,
              private userViewModelService: UserViewModelService,
              private subService: SubService,
              private likeService: LikeService,
              private postViewModelService: PostViewModelService,
              private photoService: PhotoService,
              private modalService: BsModalService,
              private router: Router,
  ) {

  }

  ngOnInit() {
    this.user = JSON.parse(localStorage.getItem("currentUser"));
    this.loadYourPageInfo();
    const idOfCustomer = this.user.idUser;
    this.loadPostViewModels(idOfCustomer);
  }

  private loadYourPageInfo() {
    this.subscriptions.push(this.userViewModelService.getUserViewModel(this.user.idUser).subscribe(model => {
      this.userViewModel = model as UserViewModel;
    }))
    this.subscriptions.push(this.userService.getUserById(this.user.idUser).subscribe( account => {
      this.user = account as User;
      localStorage.clear();
      localStorage.setItem("currentUser", JSON.stringify(account as User));
    }))
  }

  private loadPostViewModels(id: number): void {
    this.subscriptions.push(this.postViewModelService.getHomePostViewModels(id).subscribe( models => {
      this.posts = models as PostViewModel[];
    }))
  }

  public dateToString(date: Date) : string {
    let temp = new Date(date);
    return temp.getUTCDate() + ":" + temp.getUTCMonth() + ":" + temp.getUTCFullYear();
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
    this.subscriptions.push(this.likeService.addLike(new Like(this.user.idUser, postViewModel.post.idPost)).subscribe( ()=> {
      this.updateLikes(postViewModel);
    }));
  }

  private dislikePost(postViewModel: PostViewModel): void {
    this.subscriptions.push(this.likeService.deleteLike(postViewModel.like.idLike).subscribe( ()=> {
      this.updateLikes(postViewModel);
    }));
  }

  private updateLikes(postViewModel: PostViewModel): void {
    this.subscriptions.push(this.likeService.getLike(this.user.idUser, postViewModel.post.idPost).subscribe(like => {
      postViewModel.like = like as Like;
      this.likeService.countLikes((like as Like).idLike).subscribe(amount => {
        postViewModel.likeCount = amount as number;
      });
    }));
  }

  private editUser(): void {
    this.uploadProfilePhoto();
    this.subscriptions.push(this.userService.addNewUser(this.user).subscribe(() => {
        this.loadYourPageInfo();
      }
    ));
    this.closeModal();
  }

  private addNewPost(): void {
    this.newPost = new Post(this.newText, new Date(), this.user.idUser);
    this.currentFile = this.selectedFiles.item(0);
    this.photoService.uploadFile(this.currentFile).subscribe();
    this.newPostViewModel = new PostViewModel(this.user.idUser, this.newPost, "D:/Photo/" + this.currentFile.name);
    this.subscriptions.push(this.postViewModelService.addPostViewModel(this.newPostViewModel).subscribe(() => {
      this.loadPostViewModels(this.user.idUser);
      this.postService.countPosts(this.user.idUser).subscribe(amount => {
        this.userViewModel.numberOfPosts = amount as number;
      })
    }));
    this.modalRef.hide();

  }

  selectFile(event) {
    this.selectedFiles = event.target.files;
  }

  private closeModal(): void {
    this.modalRef.hide();
  }

  private exit(): void {
    localStorage.clear();
    this.router.navigate(['/login'], {});
  }


  private uploadProfilePhoto(): void {
    this.currentFile = this.selectedFiles.item(0);
    if (this.currentFile != null) {
      this.user.profilePhoto = "D:/Photo/" + this.currentFile.name;
      this.userService.uploadProfilePhoto(this.currentFile).subscribe();
    }
  }
}
