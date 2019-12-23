import { Component, OnInit } from '@angular/core';
import {Subscription} from "rxjs";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {ActivatedRoute, Router} from "@angular/router";
import {Comment} from "../../models/commentModel";
import {User} from "../../models/userModel";
import {PostViewModelService} from "../../services/postViewModel.service";
import {PostViewModel} from "../../models/postViewModel";
import {Like} from "../../models/likeModel";
import {LikeService} from "../../services/like.service";
import {PageModel} from "../../models/pageModel";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {UserService} from "../../services/user.service";

@Component({
  selector: 'app-feed',
  templateUrl: './feed.component.html',
  styleUrls: ['./feed.component.css']
})
export class FeedComponent implements OnInit {

  private subscriptions: Subscription[] = [];
  public currentUser: User;
  public currentPage: number = 0;
  public pageModel: PageModel;
  constructor(private modalService: BsModalService,
              private likeService: LikeService,
              private userService: UserService,
              private postViewModelService: PostViewModelService,
              private router: Router) { }

  ngOnInit() {
    this.userService.checkGuest(this.router);
    this.currentUser = JSON.parse(localStorage.getItem("currentUser"));
    const idOfCustomer = this.currentUser.idUser;
    this.loadPostViewModels(idOfCustomer, this.currentPage);
  }

  private loadPostViewModels(id: number, pageNo: number): void {
    this.subscriptions.push(this.postViewModelService.getFeedPageModel(id, pageNo,4).subscribe(page => {
      this.pageModel =  page as PageModel;
    }))
  }

  private dateToString(date: Date) : string {
    let temp = new Date(date);
    return temp.getUTCDate() + "." + temp.getUTCMonth() + "." + temp.getUTCFullYear();
  }


  private likePost(postViewModel: PostViewModel): void {
    this.subscriptions.push(this.likeService.saveLike(new Like(this.currentUser.idUser, postViewModel.post.idPost)).subscribe( ()=> {
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
      this.likeService.countLikes(postViewModel.post.idPost).subscribe(amount => {
        postViewModel.likeCount = amount as number;
      });
    }));
  }

  pageChanged(event: any): void {
    this.loadPostViewModels(this.currentUser.idUser, event.page - 1);
    let scrollToTop = window.setInterval(() => {
      let pos = window.pageYOffset;
      if (pos > 200) {
        window.scrollTo(0, pos - 200); // how far to scroll on each step
      } else {
        window.clearInterval(scrollToTop);
      }
    }, 16);
    this.currentPage = event.page - 1;
  }
}
