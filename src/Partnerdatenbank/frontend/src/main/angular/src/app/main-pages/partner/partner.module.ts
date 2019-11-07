import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {AngularMaterialModule} from "../../material-module";
import {PartnerComponent} from "./partner.component";
import {PaginationComponent} from './pagination/pagination.component';
import {GridlistComponent} from './gridlist/gridlist.component';
import {partnerRouting} from "./partner.routing";


@NgModule({
  declarations: [PartnerComponent, PaginationComponent, GridlistComponent],
  imports: [
    CommonModule,
    partnerRouting,
    AngularMaterialModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class PartnerModule { }
