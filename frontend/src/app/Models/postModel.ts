export class Post{
  id: number;
  text:string;
  date: Date;
  idAuthor: number;
  likeCount:number;


  constructor(id: number, text: string, date: Date, idAuthor: number, likeCount: number) {
    this.id = id;
    this.text = text;
    this.date = date;
    this.idAuthor = idAuthor;
    this.likeCount = likeCount;
  }
}
