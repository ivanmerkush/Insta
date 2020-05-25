import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Status, User} from "../models/userModel";
import {Router} from "@angular/router";

@Injectable()
export class  UserService { //todo create interface

  constructor(private http: HttpClient) {

  }

  updateUserInfo(user: User): Observable<User> {
    return this.http.post<User>('/api/users/', user);
  }

  saveUser(user: User) : Observable<User> {
    return this.http.post<User>('/api/users/', user);
  }

  blockUser(user: User): Observable<User> {
    return this.http.put<User>('/api/users/block', user);
  }

  unblockUser(user: User): Observable<User> {
    return this.http.put<User>('/api/users/unblock', user);
  }

  getUserById(id: number): Observable<User> {
    return this.http.get<User>('/api/users/id/' + id);
  }

  getUsersBySearch(searchWord: string): Observable<User[]> {
    return this.http.get<User[]>('/api/users/search?request=' + searchWord);
  }

  getUserByNickname(name: string): Observable<User> {
    return this.http.get<User>('/api/users/login/' + name);
  }

  getUserByNicknameAndPassword(nickname: string, password: string): Observable<User> {
    return this.http.get<User>('/api/users/login?nickname=' + nickname + '&password=' + password);
  }

  deleteUser(id: number): Observable<void> {
    return this.http.delete<void>('/api/users/' + id);
  }

  uploadProfilePhoto(file: File): Observable<File> {
    const formdata: FormData = new FormData();
    formdata.append('file', file);
    return this.http.post<File>('api/users/upload', formdata);
  }

  checkGuest(router: Router) : void {
    let curUser = JSON.parse(localStorage.getItem("currentUser"));
    if(!curUser) {
      router.navigate(['/login'],{});
    }
  }

}
