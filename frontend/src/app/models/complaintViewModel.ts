import {Complaint} from "./complaintModel";

export class ComplaintViewModel {
  prosecutorNickname: string;
  prosecutorPhoto: string;
  accusedNickname: string;
  accusedPhoto: string;
  complaint: Complaint;

  constructor(prosecutorNickname: string, prosecutorPhoto: string, accusedNickname: string, accusedPhoto: string, complaint: Complaint) {
    this.prosecutorNickname = prosecutorNickname;
    this.prosecutorPhoto = prosecutorPhoto;
    this.accusedNickname = accusedNickname;
    this.accusedPhoto = accusedPhoto;
    this.complaint = complaint;
  }
}
