import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Sub} from "../models/subModel";

@Injectable()
export class SubService{
  constructor(private http: HttpClient) {

  }

  getSub(idHost: number, idSub: number) : Observable<Sub> {
    return this.http.get<Sub>('/api/subs/host/'+ idHost + '/sub/' + idSub);
  }

  deleteSub(id: number): Observable<void> {
    return this.http.delete<void>('/api/subs/' + id);
  }

  addSub(sub: Sub): Observable<Sub> {
    return this.http.post<Sub>('/api/subs', sub);
  }

  countSubscribers(id: number) : Observable<number> {
    return this.http.get<number>('/api/subs/host' + id);
  }
  countSubscriptions(id: number) : Observable<number> {
    return this.http.get<number>('/api/subs/sub' + id);
  }

  isBondExists(idHost: number, idSub: number) : Observable<boolean> {
    return this.http.get<boolean>('api/subs/host' + idHost + '/sub' + idSub);
  }

  getSubscriptions(id: number) : Observable<Sub[]> {
    return this.http.get<Sub[]>('api/subs/' + id);
  }
}
