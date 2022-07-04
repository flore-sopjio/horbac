import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {environment} from '../../environments/environment';
import {HierarchicalSupevisorDTO} from '../model/hierarchicalSupervisor-dto';

@Injectable({
  providedIn: 'root'
})
export class HierarchicalSupervisorService {

  constructor(
    public http: HttpClient
  ) { }

  public createSupervisor(supervisor: HierarchicalSupevisorDTO): Observable<HierarchicalSupevisorDTO> {
    let host = environment.host;
    return this.http.post<HierarchicalSupevisorDTO>(host + '/supervisor/new', supervisor);
  }

  public getAllSupervisor(): Observable<HierarchicalSupevisorDTO[]> {
    let host = environment.host;
    return this.http.get<HierarchicalSupevisorDTO[]>(host + '/supervisor/allSupervisor');
  }

  public getAllUnity(): Observable<string[]> {
    let host = environment.host;
    return this.http.get<string[]>(host + '/supervisor/allUnity');
  }
}
