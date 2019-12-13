import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {UserViewModel} from "../models/userViewModel";
import {User} from "../models/userModel";

@Injectable()
export class UserViewModelService {
  constructor(private http: HttpClient) {

  }

  getUserViewModel(id: number) : Observable<UserViewModel> {
    return this.http.get<UserViewModel>('/api/userview/' + id);
  }

}
