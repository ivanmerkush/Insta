import {Role, Status} from "./userModel";

export class Complaint{
  idComplaint: number;
  reason:Reason;
  adInfo: string;
  fillingDate: Date;
  idAccused: number;
  idProsecutor: number;


  constructor(reason: Reason, adInfo: string, fillingDate: Date, idAccused: number, idProsecutor: number) {
    this.reason = reason;
    this.adInfo = adInfo;
    this.fillingDate = fillingDate;
    this.idAccused = idAccused;
    this.idProsecutor = idProsecutor;
  }
}

export enum Reason {
  SPAM,
  OBSCENITY
}
