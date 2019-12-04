import { Component, OnInit } from '@angular/core';
import {Subscription} from "rxjs";
import {Photo} from "../../modules/photoModel";
import {Post} from "../../modules/postModel";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {PostService} from "../../services/post.service";
import {PhotoService} from "../../services/photo.service";
import {ActivatedRoute} from "@angular/router";
import {Comment} from "../../modules/commentModel";
import {PostPhotoLike} from "../../modules/postPhotoLike";
import {SubService} from "../../services/sub.service";
import {User} from "../../modules/userModel";
import {Sub} from "../../modules/subModel";

@Component({
  selector: 'app-feed',
  templateUrl: './feed.component.html',
  styleUrls: ['./feed.component.css']
})
export class FeedComponent implements OnInit {

  private subscriptions: Subscription[] = [];
  public currentUser: User;
  public subs: Sub[] = [];
  public followedUsers: User[] = [];
  public postPhotoLikes: PostPhotoLike[] = [];
  public photos: Photo[] = [];
  public posts: Post[] = [];

  constructor(private postService: PostService,
              private modalService: BsModalService,
              private subService: SubService,
              private photoService: PhotoService,
              private activateRoute: ActivatedRoute) { }

  public comments: Comment[];
  ngOnInit() {
    this.currentUser = JSON.parse(localStorage.getItem("currentUser"));
    const idOfCustomer = this.currentUser.idUser;
    this.loadSubscriptions(idOfCustomer);
  }

  private loadSubscriptions(id: number): void {
    this.subscriptions.push(this.subService.getSubscriptions(id).subscribe(subs => {
      this.subs = subs as Sub[];
      this.subs.forEach(sub => {
        this.loadPosts(sub.idHost);
      })
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

  public dateToString(date: Date) : string {
    let temp = new Date(date);
    return temp.getUTCDate() + ":" + temp.getUTCMonth() + ":" + temp.getUTCFullYear();
  }

}
