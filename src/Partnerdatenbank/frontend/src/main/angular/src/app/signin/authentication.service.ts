import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {configuration} from "../../configuration/configuration";
import {BehaviorSubject} from "rxjs/internal/BehaviorSubject";
import {Observable} from "rxjs/internal/Observable";
import {Principal} from "../models/user/Principal";

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  private readonly BASEURL: string = configuration.BASEURL;

  private loggedInUserSubject: BehaviorSubject<Principal>;
  public loggedInUser: Observable<Principal>;

  constructor(
    private http: HttpClient
  ) {
    this.loggedInUserSubject = new BehaviorSubject<Principal>(null);
    this.loggedInUser = this.loggedInUserSubject.asObservable();
  }

  public login(username: string, password: string) {
    // use formData cause the login of Spring requires the credentials
    // to be delivered in a formData
    let formData: FormData = new FormData();
    formData.append("username", username);
    formData.append("password", password);

    return this.http.post(this.BASEURL + "/login", formData);
  }

  public logout(): Observable<any> {
    return this.http.post(this.BASEURL + "/logout", null);
  }

  public user() {
    return this.http.get(this.BASEURL + "/user");
  }

  public setLoggedUser(loggedUser: Principal): void {
    this.loggedInUserSubject.next(loggedUser);
  }

  public getLoggedUser(): Principal {
    return this.loggedInUserSubject.value;
  }
}
