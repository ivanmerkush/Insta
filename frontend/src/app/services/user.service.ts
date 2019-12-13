import {Injectable} from "@angular/core";
import {HttpClient, HttpRequest} from "@angular/common/http";
import {Observable} from "rxjs";
import {User} from "../models/userModel";

@Injectable()
export class  UserService { //todo create interface

  constructor(private http: HttpClient) {

  }

  updateUserInfo(user: User): Observable<User> {
    return this.http.post<User>('/api/users/', user);
  }

  addNewUser(user: User) : Observable<User> {
    return this.http.post<User>('/api/users/', user);
  }

  getUserById(id: number): Observable<User> {
    return this.http.get<User>('/api/users/id' + id);
  }

  getUsersBySearch(searchWord: string): Observable<User[]> {
    return this.http.get<User[]>('/api/users/' + searchWord);
  }

  getUserByNickname(name: string): Observable<User> {
    return this.http.get<User>('/api/users/login' + name);
  }

  deleteUser(id: number): Observable<void> {
    return this.http.delete<void>('/api/users/' + id);
  }

  uploadProfilePhoto(file: File): Observable<File> {
    const formdata: FormData = new FormData();
    formdata.append('file', file);
    return this.http.post<File>('api/users/upload', formdata);
  }
}
