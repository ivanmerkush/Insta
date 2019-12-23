export class CommentViewModel {
  nickname: string;
  profilePhoto: string;
  idComment: number;
  text: string;
  date: Date;
  idAuthor: number;
  idPost: number;


  constructor(nickname: string, profilePhoto: string, idComment: number, text: string, date: Date, idAuthor: number, idPost: number) {
    this.nickname = nickname;
    this.profilePhoto = profilePhoto;
    this.idComment = idComment;
    this.text = text;
    this.date = date;
    this.idAuthor = idAuthor;
    this.idPost = idPost;
  }
}
