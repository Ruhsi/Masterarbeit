import { Component, OnInit } from '@angular/core';
import {Company} from 'src/app/models/company/company';
import {CompanyService} from 'src/app/services/company.service';

@Component({
  selector: 'app-company',
  templateUrl: './company.component.html',
  styleUrls: ['./company.component.scss']
})
export class CompanyComponent implements OnInit {

  panelOpenState = false;

  companies: Array<Company>;

  constructor(private companyService: CompanyService) { }

  ngOnInit() {
    this.companyService.getAllCompanies()
      .subscribe((companies: Array<Company>) => this.companies = companies);
  }

}
