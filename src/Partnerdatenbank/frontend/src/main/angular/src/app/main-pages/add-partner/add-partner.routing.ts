import {RouterModule, Routes} from '@angular/router';
import {ModuleWithProviders} from '@angular/core';
import {AddPartnerComponent} from "./add-partner.component";


export const addPartnerRoutes: Routes = [
  {
    path: '',
    component: AddPartnerComponent,
    data: {
      pageTitle: 'AddPartner'
    }
  },
];

export const addPartnerRouting: ModuleWithProviders = RouterModule.forChild(addPartnerRoutes);

