export class Comment{
  _postid: number;
  _author: string;
  _text: string;
  _dateTime: time;


  constructor(postid: number,author: string, text: string, dateTime: time) {
    this._postid = postid;
    this._author = author;
    this._text = text;
    this._dateTime = dateTime;
  }
}

interface time {
  hours : number;
  minutes: number;
  seconds:number;
}
