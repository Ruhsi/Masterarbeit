import {Component, OnInit, ViewChild} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Partner} from "../../models/partner/Partner";
import {Address} from "../../models/partner/Address";
import {MailAddress} from "../../models/partner/MailAddress";
import {PhoneNumber} from "../../models/partner/PhoneNumber";
import {MatHorizontalStepper, MatSnackBar, MatSnackBarConfig} from "@angular/material";
import {PartnerService} from "../../services/partner.service";

@Component({
  selector: 'app-add-partner',
  templateUrl: './add-partner.component.html',
  styleUrls: ['./add-partner.component.scss']
})
export class AddPartnerComponent implements OnInit {

  durationInSeconds: number = 5;

  partner: Partner;

  isLinear = true;
  firstFormGroup: FormGroup;
  secondFormGroup: FormGroup;
  thirdFormGroup: FormGroup;

  @ViewChild('stepper', {static: false}) stepper: MatHorizontalStepper;

  constructor(
    private _formBuilder: FormBuilder,
    private partnerService: PartnerService,
    private snackBar: MatSnackBar) {
  }

  ngOnInit() {
    this.partner = new Partner();
    this.partner.address = new Address();
    this.partner.mailadresses = new Array<MailAddress>();
    this.partner.phoneNumbers = new Array<PhoneNumber>();

    this.firstFormGroup = this._formBuilder.group({
      titleBeforeCtrl: this.partner.titleBefore,
      titleAfterCtrl: this.partner.titleAfter,
      firstNameCtrl: [this.partner.firstname],
      lastNameCtrl: [this.partner.lastname]
    });
    this.secondFormGroup = this._formBuilder.group({
      streetCtrl: [this.partner.address.street],
      streetNumberCtrl: [this.partner.address.streetNumber],
      postalCodeCtrl: [this.partner.address.postalCode],
      cityCtrl: [this.partner.address.city],
      countryCtrl: [this.partner.address.country]
    });
    this.thirdFormGroup = this._formBuilder.group({
      phoneNumberCtrl: [''],
      privatePhoneCtrl: [true],

      emailCtrl: [''],
      privateMailCtrl: [true]
    });
  }

  addPhoneNumber(): void {
    let phoneNumber: PhoneNumber = new PhoneNumber();
    phoneNumber.isPrivate = this.thirdFormGroup.get('privatePhoneCtrl').value;
    phoneNumber.phoneNumber = this.thirdFormGroup.get('phoneNumberCtrl').value;
    if(this.partner.phoneNumbers.filter(number => number.phoneNumber == phoneNumber.phoneNumber).length == 0){
      this.partner.phoneNumbers.push(phoneNumber);
    }
  }

  addMailAddress(): void {
    let email: MailAddress = new MailAddress();
    email.isPrivate = this.thirdFormGroup.get('privateMailCtrl').value;
    email.mailAddress = this.thirdFormGroup.get('emailCtrl').value;
    if(this.partner.mailadresses.filter(mail => mail.mailAddress == email.mailAddress).length == 0) {
      this.partner.mailadresses.push(email);
    }
  }

  addPartner(): void {
    this.partnerService.addOrUpdatePartner(this.partner)
      .subscribe((partner: Partner) => {
        this.openSnackbar("Partner erfolgreich hinzugefügt!", "x");
        this.reset();
      })
  }

  reset() {
    this.stepper.reset();
  }

  openSnackbar(message: string, action: string) {
    let config: MatSnackBarConfig = new MatSnackBarConfig();
    config.duration = this.durationInSeconds * 1000;
    this.snackBar.open(message, action, config);
  }

  removePhonenumber(i: number) {
    this.partner.phoneNumbers.splice(i, 1);
  }

  removeMailaddress(i: number){
    this.partner.mailadresses.splice(i, 1);
  }

}
