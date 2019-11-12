import {Component, OnDestroy, OnInit} from '@angular/core';
import {Partner} from "../../../models/partner/Partner";
import {PartnerService} from './partner.service';
import {Link} from 'src/app/models/link/Link';
import {LinkService} from 'src/app/services/link.service';
import {Company} from "../../../models/company/company";
import {Subscription} from "rxjs/internal/Subscription";


@Component({
  selector: 'app-partner',
  templateUrl: './partner.component.html',
  styleUrls: ['./partner.component.scss']
})
export class PartnerComponent implements OnInit, OnDestroy {

  private companyOfSelectedPartner: Company;
  private selectedPartner: Partner;
  private links: Array<Link>;

  private companyOfSelectedPartnerSubscription: Subscription;
  private selectedPartnerSubscription: Subscription;
  private getAllLinksSubscription: Subscription;

  constructor(
    private partnerService: PartnerService,
    private linkService: LinkService
  ) {
  }

  ngOnInit() {
    this.getSelectedPartner();
  }

  ngOnDestroy(): void {
    this.companyOfSelectedPartnerSubscription && this.companyOfSelectedPartnerSubscription.unsubscribe();
    this.selectedPartnerSubscription && this.selectedPartnerSubscription.unsubscribe();
    this.getAllLinksSubscription && this.getAllLinksSubscription.unsubscribe();
  }

  getSelectedPartner(): void {
    this.companyOfSelectedPartnerSubscription = this.partnerService.companyOfSelectedPartner.subscribe((company: Company) => {
      this.companyOfSelectedPartner = company;
    });
    this.selectedPartnerSubscription = this.partnerService.selectedPartner.subscribe((partner: Partner) => {
      this.selectedPartner = partner;
      if (partner != null)
        this.getAllLinksSubscription = this.linkService.getAllLinksOfPartner(partner.id)
          .subscribe((links: Array<Link>) => {
            this.links = links;
          });
    });
  }



}
