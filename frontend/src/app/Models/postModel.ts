export class Post{
  _id: number;
  _author:string
  _photoPath:string;
  _text:string;
  _likes:number;
  _date: Date;


  constructor(id: number, author: string, photoPath: string, text: string, likes: number, date: Date) {
    this._id = id;
    this._author = author;
    this._photoPath = photoPath;
    this._text = text;
    this._likes = likes;
    this._date = date;
  }
  get author(): string {
    return this._author;
  }

  set author(value: string) {
    this._author = value;
  }

  get photoPath(): string {
    return this._photoPath;
  }

  set photoPath(value: string) {
    this._photoPath = value;
  }

  get text(): string {
    return this._text;
  }

  set text(value: string) {
    this._text = value;
  }

  get likes(): number {
    return this._likes;
  }

  set likes(value: number) {
    this._likes = value;
  }

  get date(): Date {
    return this._date;
  }

  set date(value: Date) {
    this._date = value;
  }
}
