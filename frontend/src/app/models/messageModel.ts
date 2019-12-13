export class Message {
  idDirect: number;
  message: string;
  date: Date;
  idReceiver: number;
  idSender: number;


  constructor(idDirect: number, message: string, date: Date, idReceiver: number, idSender: number) {
    this.idDirect = idDirect;
    this.message = message;
    this.date = date;
    this.idReceiver = idReceiver;
    this.idSender = idSender;
  }
}
