import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs/internal/Observable";
import {Partner} from '../models/partner/Partner';
import {retry} from "rxjs/operators";
import {Link} from '../models/link/Link';
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class LinkService {

  private readonly URL = environment.backendOriginSegment + ":" + environment.backendOriginPort;

  private headers = new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8');

  constructor(private http: HttpClient) {
  }

  addOrUpdateLink(partnerId: number, link: Link): Observable<Partner> {
    return this.http.post<Partner>(this.URL + "/link/" + partnerId,
      JSON.stringify(link, link.constructor.prototype),
      {headers: this.headers})
      .pipe(
        retry(1)
      );
  }

  getAllLinksOfPartner(partnerId: number) {
    return this.http.get(this.URL + "/links/partner/" + partnerId);
  }

  deleteLink(link: Link) {
    return this.http.delete(this.URL + "/link/" + link.id);
  }


}
