import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {PostViewModel} from "../models/postViewModel";
import {PageModel} from "../models/pageModel";

@Injectable()
export class PostViewModelService {
  constructor(private http: HttpClient) {

  }

  getFeedPageModel(id: number, pageNo: number, pageSize: number) : Observable<PageModel> {
    return this.http.get<PageModel>('/api/page/feed?id=' + id + '&offset=' + pageNo + '&limit=' + pageSize);
  }

  getHomePageModel(id: number, pageNo: number, pageSize: number):  Observable<PageModel> {
    return this.http.get<PageModel>('/api/page/home?id=' + id + '&offset=' + pageNo + '&limit=' + pageSize);
  }

  getHashtagPageModel(idHashtag: number, pageNo: number, pageSize: number):  Observable<PageModel> {
    return this.http.get<PageModel>('/api/page/hashtag?id=' + idHashtag + '&offset=' + pageNo + '&limit=' + pageSize);
  }

  savePostViewModel(postViewModel: PostViewModel) : Observable<PostViewModel> {
    return this.http.post<PostViewModel>('/api/page/upload',postViewModel);
  }
}
