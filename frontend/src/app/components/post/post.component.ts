import { Component, OnInit } from '@angular/core';
import {Post} from "../../Models/postModel";
import {Comment} from "../../Models/commentModel";

@Component({
  selector: 'app-posts',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit {

  public posts: Post[];
  constructor() { }
  public comments: Comment[];
  ngOnInit() {
    this.posts =[new Post(1,"Example", "assets\\photos\\242155.jpg", "post #1", 12, new Date(2018, 10,20)),
      new Post(2,"Example", "assets\\photos\\2.jpg", "post #2", 45, new Date(2019, 9,15)),
        new Post(3,"Example", "assets\\photos\\Nature.jpg", "post #3", 12, new Date(2018, 10,13)),
      new Post(4,"Example", "assets\\photos\\Nature2.jpg", "post #4", 12, new Date(2018, 12,13))];
    this.comments=[new Comment(1, "Otvertka", "some text", {hours: 12, minutes:15, seconds:34}),
      new Comment(2, "Jim", "some text", {hours: 12, minutes:32, seconds:45}),
      new Comment(1, "Lily", "some text", {hours: 13, minutes:4, seconds:34}),
      new Comment(1, "Tom", "some text", {hours: 4, minutes:15, seconds:34})];
  }

}
