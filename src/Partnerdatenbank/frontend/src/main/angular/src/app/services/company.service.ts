import { Injectable } from '@angular/core';
import {retry} from "rxjs/operators";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs/internal/Observable";
import {Company} from '../models/company/company';
import {configuration} from 'src/configuration/configuration';

@Injectable({
  providedIn: 'root'
})
export class CompanyService {

private readonly URL = configuration.BASEURL;

  private headers = new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8');

  constructor(
    private http: HttpClient
  ) { }

  addOrUpdateCompany(company: Company): Observable<Company> {
    return this.http.post<Company>(this.URL + "/company", JSON.stringify(company, company.constructor.prototype), {headers: this.headers})
      .pipe(
        retry(1)
      );
  }

  getAllCompanies(){
    return this.http.get(this.URL + "/companies");
  }

  deleteCompany(partner: Company){
    return this.http.delete(this.URL + "/docsis/" + partner.id);
  }
}
