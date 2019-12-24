import { Component, OnInit } from '@angular/core';
import {Subscription} from "rxjs";
import {User} from "../../models/userModel";
import {PageModel} from "../../models/pageModel";
import {LikeService} from "../../services/like.service";
import {PostViewModelService} from "../../services/postViewModel.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {PostViewModel} from "../../models/postViewModel";
import {Like} from "../../models/likeModel";
import {UserService} from "../../services/user.service";

@Component({
  selector: 'app-hashtag',
  templateUrl: './hashtag.component.html',
  styleUrls: ['./hashtag.component.css']
})
export class HashtagComponent implements OnInit {

  private subscriptions: Subscription[] = [];
  public currentUser: User;
  public postExist: boolean;
  public currentPage: number = 0;
  public pageModel: PageModel;
  constructor(private likeService: LikeService,
              private postViewModelService: PostViewModelService,
              private activateRoute: ActivatedRoute,
              private userService: UserService,
              private router: Router) { }

  ngOnInit() {
    this.userService.checkGuest(this.router);
    const id = this.activateRoute.snapshot.params['id'];
    this.loadPostViewModels(id, this.currentPage);
  }

  private loadPostViewModels(id: number, pageNo: number): void {
    this.subscriptions.push(this.postViewModelService.getHashtagPageModel(id, pageNo,4).subscribe(page => {
      this.pageModel =  page as PageModel;
      if(this.pageModel.totalElements == 0) {
        this.postExist = false;
      }
      else {
        this.postExist = true;
      }
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
