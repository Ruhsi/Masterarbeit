import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {configuration} from "../../../configuration/configuration";
import {ErrorHandleService} from "../error-handle.service";

@Injectable({
  providedIn: 'root'
})
export class HomeService {

  URL: string = configuration.BASEURL;

  constructor(
    private http: HttpClient,
    private errorHandlService: ErrorHandleService
  ) {
  }

  // Http Headers
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };
}
