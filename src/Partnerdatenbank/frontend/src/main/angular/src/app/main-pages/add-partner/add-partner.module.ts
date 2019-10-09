import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {addPartnerRouting} from "./add-partner.routing";
import {AddPartnerComponent} from "./add-partner.component";
import {AngularMaterialModule} from "../../material-module";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";


@NgModule({
  declarations: [AddPartnerComponent],
  imports: [
    CommonModule,
    addPartnerRouting,
    AngularMaterialModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class AddPartnerPagesModule { }
