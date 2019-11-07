import {RouterModule, Routes} from '@angular/router';
import {ModuleWithProviders} from '@angular/core';
import {CompanyComponent} from './company.component';


export const companyRoutes: Routes = [
  {
    path: '',
    component: CompanyComponent,
    data: {
      pageTitle: 'Company'
    }
  },
];

export const companyRouting: ModuleWithProviders = RouterModule.forChild(companyRoutes);

