import {Component, OnInit} from '@angular/core';
import {Partner} from "../../models/partner/Partner";
import {PartnerService} from "../../services/partner.service";

@Component({
  selector: 'app-partner',
  templateUrl: './partner.component.html',
  styleUrls: ['./partner.component.scss']
})
export class PartnerComponent implements OnInit {

  private partners: Array<Partner>;

  constructor(
    private partnerService: PartnerService
  ) {
  }

  ngOnInit() {
    this.getAllPartners();
  }

  reloadPartners(){
    this.getAllPartners();
  }

  getAllPartners(): void {
    this.partnerService.getAllPartners()
      .subscribe((partners: Array<Partner>) => {
        this.partners = partners;
      })
  }

}
