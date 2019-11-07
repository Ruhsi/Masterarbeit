import {HttpHeaders} from "@angular/common/http";

export const configuration = {
    // Base url
    BASEURL: 'http://localhost:8080',

    PAGES: {
      HOME: '/home',
      ADDPARTNER: '/addpartner',
      PARTNER: '/partner',
      ADDCOMPANY: '/addcompany',
      COMPANY: '/company',
      LOGIN: '/login'
    },

    // Http Headers
    httpOptionsWithHeader: {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
      }),
      withCredentials: true
    },

    httpOptionsLogin: {
      headers: new HttpHeaders({
        "Accept": "application/json"
      }),
      withCredentials: true
    }
  }
;
