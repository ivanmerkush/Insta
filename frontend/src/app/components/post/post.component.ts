import { Component, OnInit } from '@angular/core';
import {Post} from "../../Models/postModel";
import {Comment} from "../../Models/commentModel";
import {PostService} from "../../services/post.service";
import {Subscription} from "rxjs";
import {ActivatedRoute} from "@angular/router";
import {Photo} from "../../Models/photoModel";

@Component({
  selector: 'app-posts',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit {

  private subscriptions: Subscription[] = [];
  public photos: Photo[];
  public posts: Post[];
  constructor(private postService: PostService,
              private activateRoute: ActivatedRoute) { }
  public comments: Comment[];
  ngOnInit() {
    const id = this.activateRoute.snapshot.params['id'];
    //this.loadPosts(id);
    this.photos = [new Photo(1, "C:\\Users\\Ivan\\Desktop\\5jpg.jpg", 1)];
    }

  // private loadPosts(id: number): void {
  //   this.subscriptions.push(this.postService.getPosts(id).subscribe(posts => {
  //     this.posts = posts as Post[];
  //   }))
  // }



}
