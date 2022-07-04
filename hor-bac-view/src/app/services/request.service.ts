import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {RequestDTO} from '../model/request-dto'
import { Observable } from 'rxjs';
import {environment} from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class RequestService {

  constructor(
    public http: HttpClient
  ) { }

  public createResquest(request: RequestDTO): Observable<RequestDTO> {
    let host = environment.host;
    return this.http.post<RequestDTO>(host + '/request/req', request);
  }
}
