import {Component, OnInit, TemplateRef} from '@angular/core';
import {User} from "../../modules/userModel";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {UserService} from "../../services/user.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {Post} from "../../modules/postModel";
import {Photo} from "../../modules/photoModel";
import {PostPhotoLike} from "../../modules/postPhotoLike";
import {Subscription} from "rxjs";
import {PostService} from "../../services/post.service";
import {PhotoService} from "../../services/photo.service";
import {HttpResponse} from "@angular/common/http";
import {SubService} from "../../services/sub.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  currentFile: File;
  selectedFiles: FileList;
  public user:User;
  public posts: Post[] = [];
  private photos: Photo[] = [];
  public subscriptions: Subscription[] = [];
  public postPhotoLikes: PostPhotoLike[] = [];
  public modalRef: BsModalRef;

  public numberOfPosts: number = 0;
  public followers: number;
  public follows: number;

  public newPost: Post;
  public newText: string;
  public newPhoto: Photo;

  constructor(private userService: UserService,
              private postService: PostService,
              private subService: SubService,
              private photoService: PhotoService,
              private modalService: BsModalService,
              private router: Router,
              ) {

  }

  ngOnInit() {
    this.loadYourPageInfo();
    this.loadPosts(this.user.idUser);
  }

  private loadYourPageInfo() {
    this.user = JSON.parse(localStorage.getItem("currentUser"));
    this.subscriptions.push(this.postService.countPosts(this.user.idUser).subscribe(publishes => {
      this.numberOfPosts = publishes as number;
    }));
    this.subscriptions.push(this.subService.countSubscribers(this.user.idUser).subscribe(subs => {
      this.followers = subs as number;
    }))
    this.subscriptions.push(this.subService.countSubscriptions(this.user.idUser).subscribe(sups => {
      this.follows = sups as number;
    }))
  }

  private loadPosts(id: number): void {
    this.subscriptions.push(this.postService.getPosts(id).subscribe( posts => {
      this.posts = posts as Post[];
      this.loadPhotos();
    }));
  }

  private loadPhotos() : void {
    this.posts.forEach(post => {
      this.subscriptions.push(this.photoService.getPhotoForPost(post.idPost).subscribe(photo => {
        this.photos.push(photo as Photo);
        this.uniteModels(post, photo as Photo);
      }));
    })
  }

  private uniteModels(post: Post, photo: Photo) : void {
    this.postPhotoLikes.push(new PostPhotoLike(post, photo, true));
  }

  private openEdit(template: TemplateRef<any>): void {
    this.modalRef = this.modalService.show(template);
  }

  private editUser(): void {
    this.subscriptions.push(this.userService.addNewUser(this.user).subscribe());
    this.closeModal();
  }

  private addNewPost(): void {
  }

  selectFile(event) {
    this.selectedFiles = event.target.files;
  }

  private closeModal(): void {
    this.modalRef.hide();
  }

  private exit() : void {
    localStorage.clear();
    this.router.navigate(['/login'], {});
  }


  private upload(): void {
    this.newPost = new Post(this.newText, new Date(), this.user.idUser,0);
    this.currentFile = this.selectedFiles.item(0);
    this.photoService.uploadFile(this.currentFile).subscribe(response => {

    });
    this.modalRef.hide();
  }
}
