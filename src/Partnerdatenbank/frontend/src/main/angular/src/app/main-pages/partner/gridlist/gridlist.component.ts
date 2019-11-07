import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Partner} from "../../../models/partner/Partner";
import {PartnerService} from "../../../services/partner.service";

@Component({
  selector: 'app-gridlist',
  templateUrl: './gridlist.component.html',
  styleUrls: ['./gridlist.component.scss']
})
export class GridlistComponent implements OnInit {

  @Input() partners: Array<Partner>;
  @Input('pageSize') pageSize: number;
  @Input('pageIndex') pageIndex: number;

  @Output() reloadPartnersEvent: EventEmitter<void> = new EventEmitter<void>(true);

  constructor(
    private partnerService: PartnerService
  ) { }

  ngOnInit() {
  }

  deletePartner(partner: Partner) : void {
    this.partnerService.deletePartner(partner)
      .subscribe(() => {
        this.reloadPartnersEvent.emit();
      })
  }
}
