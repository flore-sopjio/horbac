import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { DashboardChartsData, IChartProps } from './dashboard-charts-data';
import { RequestDTO } from '../../model/request-dto';
import { RequestService } from '../../services/request.service';


@Component({
  templateUrl: 'dashboard.component.html',
  styleUrls: ['dashboard.component.scss']
})
export class DashboardComponent implements OnInit {

  public visible = false;
  public response: any;

  public form: FormGroup = this.fb.group({
    subjectId: ['', Validators.required],
    organizationalUnit: ['', Validators.required],
    resourceId: ['', Validators.required],
    view: ['', Validators.required],
    actionId: ['', Validators.required],
    environmentId: ['', Validators.required]
  });


  constructor(
    private fb: FormBuilder,
    public requestService: RequestService,
  ) {
  }

  ngOnInit(): void {
  }

  public initializeForm() {
    this.form = this.fb.group({
      subjectId: ['', Validators.required],
      organizationalUnit: ['', Validators.required],
      resourceId: ['', Validators.required],
      view: ['', Validators.required],
      actionId: ['', Validators.required],
      environmentId: ['', Validators.required]
    });
  }

  public sendRequest() {
    const requestDTO: RequestDTO = this.form.value;
    this.requestService.createResquest(requestDTO).toPromise().then(res => {
      console.log(res);
      
      this.response = res;
      this.toggleLiveDemo();
      this.initializeForm();
    }).catch(err => {
      this.response = err;
      this.toggleLiveDemo();
      this.initializeForm();
    })
  }

  
  toggleLiveDemo() {
    this.visible = !this.visible;
  }

  handleLiveDemoChange(event: any) {
    this.visible = event;
  }

}
