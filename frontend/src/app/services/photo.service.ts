import {Injectable} from "@angular/core";
import {HttpClient, HttpEvent, HttpRequest} from "@angular/common/http";
import {Observable} from "rxjs";
import {Photo} from "../modules/photoModel";

@Injectable()
export class PhotoService{
  constructor(private http: HttpClient) {

  }

  getPhotoForPost(id: number) : Observable<Photo> {
    return this.http.get<Photo>('/api/photos/' + id);
  }

  uploadFile(file: File): Observable<File> {
    const formdata: FormData = new FormData();
    formdata.append('file', file);
    const req = new HttpRequest('POST', 'api/photos/uploadFile', formdata, {
      reportProgress: true,
      responseType: 'text'
    });
    return this.http.post<File>('api/photos/uploadFile', formdata);
  }

}
