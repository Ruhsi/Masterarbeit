import {Component, OnInit} from '@angular/core';
import {AuthenticationService} from "../../../../signin/authentication.service";
import {Principal} from "../../../../models/user/Principal";
import {Router} from "@angular/router";

@Component({
  selector: 'app-user-actions',
  templateUrl: './user-actions.component.html',
  styleUrls: ['./user-actions.component.scss']
})
export class UserActionsComponent implements OnInit {

  protected user: Principal;

  constructor(
    private authenticationService: AuthenticationService,
    private router: Router
  ) { }

  ngOnInit() {
    this.user = this.authenticationService.getLoggedUser();
  }

  logout() {
    this.authenticationService.logout()
      .subscribe(() => {
        this.authenticationService.setLoggedUser(null);
        this.router.navigate(["/"]);
      });
  }

}
