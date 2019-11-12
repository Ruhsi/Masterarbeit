import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {SocialLoginModule} from 'angularx-social-login';
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MainLayoutModule} from "./shared/main-layout/main-layout/main-layout.module";
import {NavigationModule} from "./shared/navigation/navigation.module";
import {HttpHeaderInterceptor} from "./shared/interceptors/HttpHeaderInterceptor";
import { LoginComponent } from './signin/login/login.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { PartnerComponent } from './main-pages/company/partner/partner.component';
import { AddCompanyComponent } from './main-pages/add-company/add-company.component';
import { CompanyComponent } from './main-pages/company/company.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    SocialLoginModule,
    HttpClientModule,
    BrowserAnimationsModule,
    NavigationModule,
    MainLayoutModule,
    FormsModule,
    ReactiveFormsModule
  ],
  exports: [
    BrowserModule,
    AppRoutingModule,
    SocialLoginModule,
    HttpClientModule,
    BrowserAnimationsModule,
    NavigationModule,
    MainLayoutModule
  ],
  providers: [
    HttpClientModule,
    {provide: HTTP_INTERCEPTORS, useClass: HttpHeaderInterceptor, multi: true}
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
