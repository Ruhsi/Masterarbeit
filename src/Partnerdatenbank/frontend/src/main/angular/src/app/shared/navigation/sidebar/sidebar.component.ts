import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {MatSidenav} from "@angular/material";
import {configuration} from "../../../../configuration/configuration";

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.scss']
})
export class SidebarComponent implements OnInit, AfterViewInit {


  readonly login: string = configuration.PAGES.LOGIN;
  readonly addpartner: string = configuration.PAGES.ADDPARTNER;
  readonly partner: string = configuration.PAGES.PARTNER;
  readonly addcompany: string = configuration.PAGES.ADDCOMPANY;
  readonly company: string = configuration.PAGES.COMPANY;
  readonly home: string = configuration.PAGES.HOME;

  @ViewChild('sidenav', {static: false}) sidenav: MatSidenav;

  constructor() {
  }

  ngOnInit(): void {

  }

  ngAfterViewInit(): void {
  }

}
