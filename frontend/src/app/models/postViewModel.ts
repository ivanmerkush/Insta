import {Post} from "./postModel";
import {Like} from "./likeModel";

export class PostViewModel {
  idUser: number;
  nickname: string;
  profilePhoto: string;
  post: Post;
  photoPath: string;
  likeCount: number;
  like: Like;


  constructor(idUser: number, post: Post, photoPath: string) {
    this.idUser = idUser;
    this.post = post;
    this.photoPath = photoPath;
  }
}
