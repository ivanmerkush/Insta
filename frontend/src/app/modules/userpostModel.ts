import {Post} from "./postModel";

export class UserPost {
  idUser: string;
  nickname: string;
  post: Post;

  constructor(nickname: string, post: Post) {
    this.nickname = nickname;
    this.post = post;
  }
}
