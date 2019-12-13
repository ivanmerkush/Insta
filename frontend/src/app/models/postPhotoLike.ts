import {Post} from "./postModel";
import {Photo} from "./photoModel";

export class PostPhotoLike {
  post: Post;
  photo: Photo;
  public like: boolean;

  constructor(post: Post, photo: Photo, like: boolean) {
    this.post = post;
    this.photo = photo;
    this.like = like;
  }

}
