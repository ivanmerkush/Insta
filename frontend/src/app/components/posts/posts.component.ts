import {Component, OnInit, TemplateRef} from '@angular/core';
import {Post} from "../../modules/postModel";
import {Comment} from "../../modules/commentModel";
import {PostService} from "../../services/post.service";
import {Subscription} from "rxjs";
import {ActivatedRoute} from "@angular/router";
import {Photo} from "../../modules/photoModel";
import {PhotoService} from "../../services/photo.service";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {PostPhotoLike} from "../../modules/postPhotoLike";

@Component({
  selector: 'app-posts',
  templateUrl: './posts.component.html',
  styleUrls: ['./posts.component.css']
})
export class PostsComponent implements OnInit {

  private subscriptions: Subscription[] = [];
  public postPhotoLikes: PostPhotoLike[] = [];
  public photos: Photo[] = [];
  public posts: Post[] = [];
  public modalRef: BsModalRef;

  constructor(private postService: PostService,
              private modalService: BsModalService,
              private photoService: PhotoService,
              private activateRoute: ActivatedRoute) { }

  public comments: Comment[];
  ngOnInit() {
    const id = this.activateRoute.snapshot.params['id'];
    this.loadPosts(id);
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

  public dateToString(date: Date) : string {
    let temp = new Date(date);
    return temp.getUTCDate() + ":" + temp.getUTCMonth() + ":" + temp.getUTCFullYear();
  }

}
