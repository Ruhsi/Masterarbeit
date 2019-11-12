import {Component, OnInit} from '@angular/core';
import {Company} from 'src/app/models/company/company';
import {CompanyService} from 'src/app/services/company.service';
import {Partner} from 'src/app/models/partner/Partner';
import {PartnerService} from './partner/partner.service';
import {Router} from "@angular/router";
import {configuration} from 'src/configuration/configuration';

@Component({
  selector: 'app-company',
  templateUrl: './company.component.html',
  styleUrls: ['./company.component.scss']
})
export class CompanyComponent implements OnInit {

  partnerSelected: boolean = false;
  panelOpenState = false;

  companies: Array<Company>;

  constructor(private companyService: CompanyService,
              private partnerService: PartnerService,
              private router: Router) { }

  ngOnInit() {
    this.companyService.getAllCompanies()
      .subscribe((companies: Array<Company>) => this.companies = companies);
  }

  openPartner(partner: Partner, company: Company){
    this.partnerSelected = true;
    this.partnerService.setCompanyOfSelectedPartner(company);
    this.partnerService.setSelectedPartner(partner);
    this.partnerSelected = true;
  }

}
