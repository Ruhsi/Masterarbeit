import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {MainLayoutComponent} from "./shared/main-layout/main-layout/main-layout.component";
import {GoogleSigninComponent} from "./signin/google-signin/google-signin.component";
import {HomePagesModule} from "./main-pages/home/home.module";
import {GoogleUserAuthenticationGuard} from "./shared/guards/google-user-authentication.guard";
import {AddPartnerPagesModule} from "./main-pages/add-partner/add-partner.module";


export const routes: Routes = [
  {
    path: 'home',
    component: MainLayoutComponent,
    loadChildren: () => HomePagesModule,
    data: { pageTitle: 'Home' },
    canActivate: [GoogleUserAuthenticationGuard]
  },
  {
    path: 'addpartner',
    component: MainLayoutComponent,
    loadChildren: () => AddPartnerPagesModule,
    data: { pageTitle: 'AddPartner' },
    canActivate: [GoogleUserAuthenticationGuard]
  },
  { path: '', redirectTo: 'login', pathMatch: 'full'},

  { path: '#', redirectTo: 'login' },

  { path: 'login', component: GoogleSigninComponent},

  { path: '**', redirectTo: 'login' }

];



@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

}
