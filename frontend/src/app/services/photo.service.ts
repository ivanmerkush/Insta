import {Injectable} from "@angular/core";
import {HttpClient, HttpEvent, HttpRequest} from "@angular/common/http";
import {Observable} from "rxjs";
import {Photo} from "../models/photoModel";

@Injectable()
export class PhotoService{
  constructor(private http: HttpClient) {

  }

  getPhotoForPost(id: number) : Observable<Photo> {
    return this.http.get<Photo>('/api/photos/' + id);
  }

  addPhoto(photo: Photo) : Observable<Photo> {
    return this.http.post<Photo>('/api/photos', photo);
  }

  uploadFile(file: File): Observable<File> {
    const formdata: FormData = new FormData();
    formdata.append('file', file);
    return this.http.post<File>('/api/photos/uploadFile', formdata);
  }

}
