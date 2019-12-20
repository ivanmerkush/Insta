import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Hashtag} from "../models/hashtagModel";

@Injectable()
export class HashtagService {
  constructor(private http: HttpClient) {

  }

  getHashtagsBySearch(searchWord: string): Observable<Hashtag[]> {
    return this.http.get<Hashtag[]>('/api/hashtags/search?request=' + searchWord);
  }
}
