import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {AngularMaterialModule} from "../../material-module";
import {addCompanyRouting} from "./add-company.routing";
import {AddCompanyComponent} from './add-company.component';


@NgModule({
  declarations: [AddCompanyComponent],
  imports: [
    CommonModule,
    addCompanyRouting,
    AngularMaterialModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class AddCompanyModule { }
