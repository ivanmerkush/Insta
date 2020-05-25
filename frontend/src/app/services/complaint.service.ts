import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Complaint} from "../models/complaintModel";
import {ComplaintViewModel} from "../models/complaintViewModel";

@Injectable()
export class ComplaintService {
  constructor(private http: HttpClient) {

  }
  getComplaints(): Observable<ComplaintViewModel[]> {
    return this.http.get<ComplaintViewModel[]>('/api/complaints/all');
  }

  getComplaintsByAccused(idAccused: number): Observable<ComplaintViewModel[]> {
    return this.http.get<ComplaintViewModel[]>('/api/complaints/accused' + idAccused);
  }

  getComplaintsByReason(reason: string): Observable<ComplaintViewModel[]> {
    return this.http.get<ComplaintViewModel[]>('/api/complaints/reason?reason=' + reason);
  }

  deleteComplaint(idProsecutor: number, idAccused: number): Observable<void> {
    return this.http.delete<void>('/api/complaints/prosecutor/' + idProsecutor + '/accused/' + idAccused);
}
  saveComplaint(complaint: Complaint): Observable<Complaint> {
    return this.http.post<Complaint>('/api/complaints', complaint);
  }


  isComplaintExists(idProsecutor: number, idAccused: number) : Observable<boolean> {
    return this.http.get<boolean>('api/complaints/prosecutor/' + idProsecutor + '/accused/' + idAccused);
  }

}
