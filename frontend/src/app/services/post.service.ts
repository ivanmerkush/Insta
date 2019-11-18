import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Post} from "../Models/postModel";

@Injectable()
export class PostService{
  constructor(private http: HttpClient) {

  }

  getPosts(id: number) : Observable<Post[]> {
    return this.http.get<Post[]>('/api/posts/' + id);
  }


}
