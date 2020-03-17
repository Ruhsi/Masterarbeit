import {Component, OnDestroy, OnInit, ViewChild} from '@angular/core';
import {Company} from 'src/app/models/company/company';
import {FormBuilder, FormGroup} from "@angular/forms";
import {MatHorizontalStepper, MatSnackBar, MatSnackBarConfig} from "@angular/material";
import {CompanyService} from 'src/app/services/company.service';
import {Address} from 'src/app/models/partner/Address';
import {Subscription} from "rxjs/internal/Subscription";

@Component({
  selector: 'app-add-company',
  templateUrl: './add-company.component.html',
  styleUrls: ['./add-company.component.scss']
})
export class AddCompanyComponent implements OnInit, OnDestroy {

  durationInSeconds: number = 5;

  company: Company;

  isLinear = true;
  firstFormGroup: FormGroup;
  secondFormGroup: FormGroup;

  private addOrUpdateCompanySubscription: Subscription;

  @ViewChild('stepper', {static: false}) stepper: MatHorizontalStepper;

  constructor(
    private _formBuilder: FormBuilder,
    private companyService: CompanyService,
    private snackBar: MatSnackBar) {
  }

  ngOnInit() {
    this.company = new Company();
    this.company.address = new Address();

    this.firstFormGroup = this._formBuilder.group({
      shortNameCtrl: [this.company.shortName],
      mandantCtrl: [this.company.mandant],
      creditorNumberCtrl: [this.company.creditorNumber],
      creditorNameCtrl: [this.company.creditorName],
      creditorStatusCtrl: [this.company.creditorStatus],
      kontoNrSAPOldCtrl: [this.company.kontoNrSAPOld],
      aendCounterCtrl: [this.company.aendCounter]

    });
    this.secondFormGroup = this._formBuilder.group({
      streetCtrl: [this.company.address.street],
      streetNumberCtrl: [this.company.address.streetNumber],
      postalCodeCtrl: [this.company.address.postalCode],
      cityCtrl: [this.company.address.city],
      countryCtrl: [this.company.address.country]
    });
  }

  ngOnDestroy(){
    this.addOrUpdateCompanySubscription && this.addOrUpdateCompanySubscription.unsubscribe();
  }

  addCompany(): void {
    this.addOrUpdateCompanySubscription = this.companyService.addOrUpdateCompany(this.company)
      .subscribe((company: Company) => {
        this.openSnackbar("Unternehmen erfolgreich hinzugefügt!", "x");
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
}
