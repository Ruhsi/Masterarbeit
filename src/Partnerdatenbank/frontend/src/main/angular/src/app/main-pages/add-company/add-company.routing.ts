import {RouterModule, Routes} from '@angular/router';
import {ModuleWithProviders} from '@angular/core';
import {AddCompanyComponent} from './add-company.component';


export const addCompanyRoutes: Routes = [
  {
    path: '',
    component: AddCompanyComponent,
    data: {
      pageTitle: 'AddCompany'
    }
  },
];

export const addCompanyRouting: ModuleWithProviders = RouterModule.forChild(addCompanyRoutes);

