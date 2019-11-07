import {
  HttpErrorResponse,
  HttpEvent,
  HttpHandler,
  HttpInterceptor,
  HttpRequest,
  HttpResponse
} from "@angular/common/http";
import {Observable} from "rxjs/internal/Observable";
import {configuration} from "../../../configuration/configuration";
import {Injectable} from "@angular/core";
import {catchError, map} from "rxjs/operators";
import {throwError} from "rxjs/internal/observable/throwError";
import {AuthenticationService} from "../../signin/authentication.service";

@Injectable()
export class HttpHeaderInterceptor implements HttpInterceptor {

  private httpOptionsWithHeader = configuration.httpOptionsWithHeader;
  private httpOptionsLogin = configuration.httpOptionsLogin;


  constructor(private authenticationService: AuthenticationService) {

  }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    console.log(req.url);
    if(req.url.toLowerCase() === configuration.BASEURL + "/login" || req.url.toLowerCase() === configuration.BASEURL + "/logout"){
      console.log(configuration.BASEURL.toLowerCase() + "/login");
      console.log(req.url.toLowerCase());
      console.log(req.url.toLowerCase() === req.url.toLowerCase());
      console.log(req.url.toLowerCase() == req.url.toLowerCase());
      req = req.clone(this.httpOptionsLogin);
    } else {
      req = req.clone(this.httpOptionsWithHeader);
    }

    console.log(req);
    return next.handle(req).pipe(
      map((event: HttpEvent<any>) => {
        if (event instanceof HttpResponse) {
          console.log("Http Response event: ", event);
        }
        return event;
      }),
      catchError(error => {
        console.log("Error response status: ", error.status);
        console.log(error);
        if (error.status === 401 || error.status == 403) {
          this.authenticationService.setLoggedUser(null);
        }
        return throwError(error);
      }));
  }

}
