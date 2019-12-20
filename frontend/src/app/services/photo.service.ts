import {Injectable} from "@angular/core";
import {HttpClient, HttpEvent, HttpRequest} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable()
export class PhotoService{
  constructor(private http: HttpClient) {

  }
  uploadFile(file: File): Observable<File> {
    const formdata: FormData = new FormData();
    formdata.append('file', file);
    return this.http.post<File>('/api/photos/uploadFile', formdata);
  }

}
