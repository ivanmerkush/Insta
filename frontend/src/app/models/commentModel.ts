export class Comment{
  idComment: number;
  text: number;
  date: Date;
  idAuthor: number;
  idPost: number;

  constructor(idComment: number, text: number, date: Date, idAuthor: number, idPost: number) {
    this.idComment = idComment;
    this.text = text;
    this.date = date;
    this.idAuthor = idAuthor;
    this.idPost = idPost;
  }
}
