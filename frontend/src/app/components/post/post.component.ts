import { Component, OnInit } from '@angular/core';
import {UserService} from "../../services/user.service";
import {ActivatedRoute, Router} from "@angular/router";
import {PostViewModelService} from "../../services/postViewModel.service";
import {CommentService} from "../../services/comment.service";
import {Subscription} from "rxjs";
import {PostViewModel} from "../../models/postViewModel";
import {Post} from "../../models/postModel";
import {CommentViewModel} from "../../models/commentViewModel";
import {User} from "../../models/userModel";
import {Comment} from "../../models/commentModel";
import {Like} from "../../models/likeModel";
import {LikeService} from "../../services/like.service";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit {

  public currentUser: User;
  public subscriptions: Subscription[] = [];
  public postViewModel: PostViewModel;
  public comments: CommentViewModel[] = [];
  public newText: string ="";
  constructor(private userService: UserService,
              private activatedRoute: ActivatedRoute,
              private router: Router,
              private postViewModelService: PostViewModelService,
              private commentService: CommentService,
              private likeService: LikeService,
              private loadService: Ng4LoadingSpinnerService) { }

  ngOnInit() {
    this.loadService.show();
    this.userService.checkGuest(this.router);
    this.currentUser = JSON.parse(localStorage.getItem("currentUser"));
    const idPost = this.activatedRoute.snapshot.params['id'];
    this.loadPost(this.currentUser.idUser, idPost);
    this.loadComments(idPost);
  }

  private loadPost(idUser: number, idPost:number) : void {
    this.subscriptions.push(this.postViewModelService.getPostViewModelByIdPost(idUser, idPost).subscribe( response => {
      this.postViewModel = response as PostViewModel;
      if(this.postViewModel == null) {
        this.router.navigate(['/**'],{});
      }
    }))
  }
  private loadComments(id: number) : void {
    this.subscriptions.push(this.commentService.getCommentsForPost(id).subscribe( response => {
      this.comments = response as CommentViewModel[];
    }))
  }

  private saveComment() : void {
    this.subscriptions.push(this.commentService.saveComment(new Comment(this.newText, new Date(), this.currentUser.idUser, this.postViewModel.post.idPost)).subscribe(() => {
      this.loadComments(this.postViewModel.post.idPost);
      this.newText = "";
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
}
