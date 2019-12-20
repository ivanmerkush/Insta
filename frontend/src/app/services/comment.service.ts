import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Comment} from "../models/commentModel";
import {CommentViewModel} from "../models/commentViewModel";

@Injectable()
export class CommentService {
  constructor(private http: HttpClient) {

  }

  getCommentsForPost(idPost: number): Observable<CommentViewModel[]> {
    return this.http.get<CommentViewModel[]>('/api/comments/' + idPost);
  }

  saveComment(comment: Comment): Observable<Comment> {
    return this.http.post<Comment>('/api/comments', comment);
  }

  deleteComment(idComment: number): Observable<void> {
    return this.http.delete<void>('/api/comments/' + idComment);
  }
}
