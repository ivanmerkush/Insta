import { Component, OnInit } from '@angular/core';
import {Subscription} from "rxjs";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {ActivatedRoute} from "@angular/router";
import {Comment} from "../../models/commentModel";
import {User} from "../../models/userModel";
import {Sub} from "../../models/subModel";
import {PostViewModelService} from "../../services/postViewModel.service";
import {PostViewModel} from "../../models/postViewModel";
import {Like} from "../../models/likeModel";
import {LikeService} from "../../services/like.service";

@Component({
  selector: 'app-feed',
  templateUrl: './feed.component.html',
  styleUrls: ['./feed.component.css']
})
export class FeedComponent implements OnInit {

  private subscriptions: Subscription[] = [];
  public currentUser: User;
  public posts: PostViewModel[] = [];

  constructor(private modalService: BsModalService,
              private likeService: LikeService,
              private postViewModelService: PostViewModelService,
              private activateRoute: ActivatedRoute) { }

  public comments: Comment[];
  ngOnInit() {
    this.currentUser = JSON.parse(localStorage.getItem("currentUser"));
    const idOfCustomer = this.currentUser.idUser;
    this.loadPostViewModels(idOfCustomer);
  }

  private loadPostViewModels(id: number): void {
    // this.subscriptions.push(this.postViewModelService.getFeedPostViewModels(id).subscribe( models => {
    //   this.posts = models as PostViewModel[];
    // }))
  }

  private dateToString(date: Date) : string {
    let temp = new Date(date);
    return temp.getUTCDate() + ":" + temp.getUTCMonth() + ":" + temp.getUTCFullYear();
  }

  private likePost(postViewModel: PostViewModel): void {
    this.subscriptions.push(this.likeService.addLike(new Like(this.currentUser.idUser, postViewModel.post.idPost)).subscribe( ()=> {
      this.updateLikes(postViewModel);
    }));
  }

  private dislikePost(postViewModel: PostViewModel): void {
    this.subscriptions.push(this.likeService.deleteLike(postViewModel.like.idLike).subscribe( ()=> {
      this.updateLikes(postViewModel);
    }));
  }

  private updateLikes(postViewModel: PostViewModel): void {
    this.subscriptions.push(this.likeService.getLike(this.currentUser.idUser, postViewModel.post.idPost).subscribe(like => {
      postViewModel.like = like as Like;
      this.likeService.countLikes((like as Like).idLike).subscribe(amount => {
        postViewModel.likeCount = amount as number;
      });
    }));
  }

}
