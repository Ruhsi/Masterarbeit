import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {Router} from "@angular/router";
import {MatSidenav} from "@angular/material";
import {MainLayoutService} from "../../main-layout/main-layout/main-layout.service";
import {configuration} from "../../../../configuration/configuration";

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.scss']
})
export class SidebarComponent implements OnInit, AfterViewInit {


  readonly login: string = configuration.PAGES.LOGIN;
  readonly addpartner: string = configuration.PAGES.ADDPARTNER;
  readonly home: string = configuration.PAGES.HOME;

  @ViewChild('sidenav', {static: false}) sidenav: MatSidenav;

  constructor(
    private router: Router,
    private mainLayoutService: MainLayoutService
  ) {
  }

  ngOnInit(): void {

  }

  ngAfterViewInit(): void {
  }

  routeTo(location: string): void {
    this.router.navigate([location]);
  }
}
