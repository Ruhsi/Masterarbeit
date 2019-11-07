import {RouterModule, Routes} from '@angular/router';
import {ModuleWithProviders} from '@angular/core';
import {PartnerComponent} from "./partner.component";


export const partnerRoutes: Routes = [
  {
    path: '',
    component: PartnerComponent,
    data: {
      pageTitle: 'Partner'
    }
  },
];

export const partnerRouting: ModuleWithProviders = RouterModule.forChild(partnerRoutes);

