import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {AngularMaterialModule} from "../../material-module";
import {companyRouting} from "./company.routing";
import {CompanyComponent} from './company.component';


@NgModule({
  declarations: [CompanyComponent],
  imports: [
    CommonModule,
    companyRouting,
    AngularMaterialModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class CompanyModule { }
