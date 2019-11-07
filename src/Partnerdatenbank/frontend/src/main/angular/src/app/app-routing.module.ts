import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {MainLayoutComponent} from "./shared/main-layout/main-layout/main-layout.component";
import {HomePagesModule} from "./main-pages/home/home.module";
import {UserAuthenticationGuard} from "./shared/guards/user-authentication.guard";
import {AddPartnerPagesModule} from "./main-pages/add-partner/add-partner.module";
import {LoginComponent} from "./signin/login/login.component";
import {PartnerModule} from "./main-pages/partner/partner.module";
import {AddCompanyModule} from './main-pages/add-company/add-company.module';
import {CompanyModule} from './main-pages/company/company.module';


export const routes: Routes = [
  {
    path: 'home',
    component: MainLayoutComponent,
    loadChildren: () => HomePagesModule,
    data: {pageTitle: 'Home'},
    canActivate: [UserAuthenticationGuard]
  },
  {
    path: 'addpartner',
    component: MainLayoutComponent,
    loadChildren: () => AddPartnerPagesModule,
    data: {pageTitle: 'AddPartner'},
    canActivate: [UserAuthenticationGuard]
  },
  {
    path: 'partner',
    component: MainLayoutComponent,
    loadChildren: () => PartnerModule,
    data: {pageTitle: 'Partner'},
    canActivate: [UserAuthenticationGuard]
  },
  {
    path: 'addcompany',
    component: MainLayoutComponent,
    loadChildren: () => AddCompanyModule,
    data: {pageTitle: 'AddCompany'},
    canActivate: [UserAuthenticationGuard]
  },
  {
    path: 'company',
    component: MainLayoutComponent,
    loadChildren: () => CompanyModule,
    data: {pageTitle: 'Company'},
    canActivate: [UserAuthenticationGuard]
  },
  {path: '', redirectTo: 'login', pathMatch: 'full'},

  {path: '#', redirectTo: 'login'},

   {path: 'login', component: LoginComponent},

  {path: '**', redirectTo: 'login'}

];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

}
