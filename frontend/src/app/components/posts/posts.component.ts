import {Component, OnInit, TemplateRef} from '@angular/core';
import {Post} from "../../models/postModel";
import {Comment} from "../../models/commentModel";
import {PostService} from "../../services/post.service";
import {Subscription} from "rxjs";
import {ActivatedRoute, Router} from "@angular/router";
import {Photo} from "../../models/photoModel";
import {PhotoService} from "../../services/photo.service";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {PostPhotoLike} from "../../models/postPhotoLike";
import {PostViewModel} from "../../models/postViewModel";
import {User} from "../../models/userModel";
import {PageModel} from "../../models/pageModel";
import {PostViewModelService} from "../../services/postViewModel.service";
import {Like} from "../../models/likeModel";
import {LikeService} from "../../services/like.service";
import {UserService} from "../../services/user.service";

@Component({
  selector: 'app-posts',
  templateUrl: './posts.component.html',
  styleUrls: ['./posts.component.css']
})
export class PostsComponent implements OnInit {

  private subscriptions: Subscription[] = [];
  public user: User;
  public pageModel: PageModel;
  public currentUser: User;
  public currentPage: number = 0;
  constructor(private postService: PostService,
              private modalService: BsModalService,
              private likeService: LikeService,
              private activateRoute: ActivatedRoute,
              private postViewModelService: PostViewModelService,
              private userService: UserService,
              private router: Router) { }

  ngOnInit() {
    this.userService.checkGuest(this.router);
    this.currentUser = JSON.parse(localStorage.getItem("currentUser"));
    const id = this.activateRoute.snapshot.params['id'];
    this.loadPostViewModels(id, this.currentPage);
  }

  private loadPostViewModels(id: number, pageNo: number): void {
    this.subscriptions.push(this.postViewModelService.getHomePageModel(id, pageNo, 4).subscribe(page => {
      this.pageModel = page as PageModel;
    }))
  }

  public dateToString(date: Date) : string {
    let temp = new Date(date);
    return temp.getUTCDate() + ":" + temp.getUTCMonth() + ":" + temp.getUTCFullYear();
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
      if (pos > 750) {
        window.scrollTo(0, pos - 200); // how far to scroll on each step
      } else {
        window.clearInterval(scrollToTop);
      }
    }, 16);
    this.currentPage = event.page - 1;
  }
}
