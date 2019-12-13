import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Post} from "../models/postModel";

@Injectable()
export class PostService{
  constructor(private http: HttpClient) {

  }

  getPosts(id: number) : Observable<Post[]> {
    return this.http.get<Post[]>('/api/posts/' + id);
  }

  deletePost(id: number): Observable<void> {
    return this.http.delete<void>('/api/posts/' + id);
  }

  countPosts(id: number) : Observable<number> {
    return this.http.get<number>('/api/posts/count' + id);
  }

}
