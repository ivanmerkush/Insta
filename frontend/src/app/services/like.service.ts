import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Sub} from "../models/subModel";
import {Like} from "../models/likeModel";

@Injectable()
export class LikeService {
  constructor(private http: HttpClient) {

  }

  getLike(idUser: number, idPost: number): Observable<Like> {
    return this.http.get<Like>('/api/likes/user/' + idUser + '/post/' + idPost);
  }

  deleteLike(id: number): Observable<void> {
    return this.http.delete<void>('/api/likes/' + id);
  }

  addLike(like: Like): Observable<Like> {
    return this.http.post<Like>('/api/likes', like);
  }

  countLikes(id: number): Observable<number> {
    return this.http.get<number>('/api/likes/count/' + id);
  }
}
