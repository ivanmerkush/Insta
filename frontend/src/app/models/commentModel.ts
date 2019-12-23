export class Comment{
  idComment: number;
  text: string;
  dateTime: Date;
  idAuthor: number;
  idPost: number;

  constructor(text: string, date: Date, idAuthor: number, idPost: number) {
    this.text = text;
    this.dateTime = date;
    this.idAuthor = idAuthor;
    this.idPost = idPost;
  }
}
