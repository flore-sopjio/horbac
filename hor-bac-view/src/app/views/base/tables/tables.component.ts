import { Component, OnInit } from '@angular/core';
import { RequestDTO } from 'src/app/model/request-dto';
import { RequestService } from 'src/app/services/request.service';

@Component({
  selector: 'app-tables',
  templateUrl: './tables.component.html',
  styleUrls: ['./tables.component.scss']
})
export class TablesComponent implements OnInit {

  ngOnInit(): void {
    this.getRequestList();
  }

  constructor(
    public requestservice: RequestService
  ) { }

  public requestList: RequestDTO[] | undefined= [];

  public getRequestList(): void {
    this.requestservice.getAllResquest().toPromise().then(res => {
      this.requestList = res;
      console.log(res);
      
    })
  }
}
