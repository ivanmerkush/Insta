import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {PostViewModel} from "../models/postViewModel";
import {User} from "../models/userModel";

@Injectable()
export class PostViewModelService {
  constructor(private http: HttpClient) {

  }

  getFeedPostViewModels(id: number, pageNo: number, pageSize: number) : Observable<PostViewModel[]> {
    return this.http.get<PostViewModel[]>('/api/page/feed/' + id + '?offset=' + pageNo + '&limit=' + pageSize);
  }

  getHomePostViewModels(id: number):  Observable<PostViewModel[]> {
    return this.http.get<PostViewModel[]>('/api/page/home/' + id);
  }

  addPostViewModel(postViewModel: PostViewModel) : Observable<PostViewModel> {
    return this.http.post<PostViewModel>('/api/page/upload',postViewModel);
  }
}
