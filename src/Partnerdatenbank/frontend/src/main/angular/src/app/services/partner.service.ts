import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {Partner} from "../models/partner/Partner";
import {configuration} from "../../configuration/configuration";
import {retry} from "rxjs/operators";
import {Observable} from "rxjs/internal/Observable";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class PartnerService {

  private readonly URL = environment.backendOriginSegment + ":" + environment.backendOriginPort;

  private headers = new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8');

  constructor(
    private http: HttpClient
  ) {
  }

  addOrUpdatePartner(id: number, partner: Partner): Observable<Partner> {
    return this.http.post<Partner>(this.URL + "/company/" + id + "/partner",
      JSON.stringify(partner, partner.constructor.prototype),
      {headers: this.headers})
      .pipe(
        retry(1)
      );
  }

  getAllPartners() {
    return this.http.get(this.URL + "/partners");
  }

  deletePartner(partner: Partner) {
    return this.http.delete(this.URL + "/partner/" + partner.id);
  }
}
