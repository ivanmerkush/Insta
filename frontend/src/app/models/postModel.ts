export class Post{
  idPost: number;
  text:string;
  date: Date;
  idAuthor: number;


  constructor(text: string, date: Date, idAuthor: number) {
    this.text = text;
    this.date = date;
    this.idAuthor = idAuthor;
  }
}
