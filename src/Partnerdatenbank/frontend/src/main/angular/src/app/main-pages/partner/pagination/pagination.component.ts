import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Partner} from "../../../models/partner/Partner";

@Component({
  selector: 'app-pagination',
  templateUrl: './pagination.component.html',
  styleUrls: ['./pagination.component.scss']
})
export class PaginationComponent implements OnInit {

  @Input() partners: Array<Partner>;
  @Output() reloadPartnersEvent: EventEmitter<void> = new EventEmitter<void>(true);

  pageIndex = 0;
  pageSize = 10;
  pageSizeOptions = [5, 10, 20, 50, 100];

  constructor() { }

  ngOnInit() {
  }

  reloadPartners() {
    this.reloadPartnersEvent.emit();
  }
}
