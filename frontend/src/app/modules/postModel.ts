export class Post{
  public idPost: number;
  text:string;
  date: Date;
  idAuthor: number;
  likeCount:number;


  constructor(text: string, date: Date, idAuthor: number, likeCount: number) {
    this.text = text;
    this.date = date;
    this.idAuthor = idAuthor;
    this.likeCount = likeCount;
  }
}
