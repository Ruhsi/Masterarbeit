import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ErrorHandleService} from "../error-handle.service";

@Injectable({
  providedIn: 'root'
})
export class HomeService {



  constructor(
    private http: HttpClient,
    private errorHandlService: ErrorHandleService
  ) {
  }
}
