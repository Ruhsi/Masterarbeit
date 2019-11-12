import {Injectable} from '@angular/core';
import {BehaviorSubject} from "rxjs/internal/BehaviorSubject";
import {Partner} from 'src/app/models/partner/Partner';
import {Company} from "../../../models/company/company";


@Injectable({
  providedIn: 'root'
})
export class PartnerService {

  private _selectedPartner: BehaviorSubject<Partner> = new BehaviorSubject<Partner>(null);
  private _companyOfSelectedPartner: BehaviorSubject<Company> = new BehaviorSubject<Company>(null);

  constructor() {

  }


  get selectedPartner(): BehaviorSubject<Partner> {
    return this._selectedPartner;
  }

  setSelectedPartner(value: Partner) {
    this._selectedPartner.next(value);
  }


  get companyOfSelectedPartner(): BehaviorSubject<Company> {
    return this._companyOfSelectedPartner;
  }

  setCompanyOfSelectedPartner(value: Company) {
    this._companyOfSelectedPartner.next(value);
  }
}
