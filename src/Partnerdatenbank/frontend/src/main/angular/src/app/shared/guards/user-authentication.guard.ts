import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot, UrlTree} from '@angular/router';
import {Observable} from 'rxjs';
import {AuthenticationService} from "../../signin/authentication.service";
import {Principal} from "../../models/user/Principal";

@Injectable({
  providedIn: 'root'
})
export class UserAuthenticationGuard implements CanActivate {

  private readonly user: Principal;

  constructor(
    private authenticationService: AuthenticationService
  ) {
    this.user = this.authenticationService.getLoggedUser();
  }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean |
    UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    console.log(this.user);
    return this.user != null;
  }

}
