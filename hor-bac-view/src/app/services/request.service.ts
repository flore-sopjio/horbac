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

  //créer et évaluer une requête
  public createResquest(request: RequestDTO): Observable<RequestDTO> {
    let host = environment.host;
    return this.http.post<RequestDTO>(host + '/request/req', request);
  }

  //lister toutes les requêtes
  public getAllResquest(): Observable<RequestDTO[]> {
    let host = environment.host;
    return this.http.get<RequestDTO[]>(host + '/request/all');
  }

  //Valider ou refuser une requête
  public ValidateRequest(requestId: number, message: string): Observable<string> {
    const validate = {
      "requestId": requestId,
      "message": message
    }
    let host = environment.host;
    return this.http.post<string>(host + '/request/req', validate);
  }
}
