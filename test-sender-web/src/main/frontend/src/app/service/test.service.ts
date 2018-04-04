import {Injectable} from '@angular/core';
import {Headers, Http, RequestOptions} from '@angular/http';

import {environment} from '../../environments/environment';

export const TEST_API = environment.apiUrl;

@Injectable()
export class TestService {

  constructor(private http: Http) {
  }

  getMessages() {
    const headers = new Headers({'Content-Type': 'application/json'});
    const options = new RequestOptions({headers: headers});
    const url = TEST_API + '/messages';
    return this.http.get(url, options);
  }
}
