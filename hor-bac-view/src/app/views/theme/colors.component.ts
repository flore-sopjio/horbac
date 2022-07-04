import { AfterViewInit, Component, HostBinding, Inject, Input, OnInit, Renderer2 } from '@angular/core';
import { DOCUMENT } from '@angular/common';

import { getStyle, rgbToHex } from '@coreui/utils/src';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HierarchicalSupervisorService } from 'src/app/services/hierarchical-supervisor.service';
import { HierarchicalSupevisorDTO } from 'src/app/model/hierarchicalSupervisor-dto';


@Component({
  templateUrl: 'colors.component.html',
  styleUrls: ['color.component.scss']
})
export class ColorsComponent implements OnInit {

  public listUnities?: string[] | undefined;
  public listSupervisor?: HierarchicalSupevisorDTO[] | undefined;
  public visible: boolean = false;
  public response: any;

  public form: FormGroup = this.fb.group({
    nom: ['', Validators.required],
    organisationalUnit: ['', Validators.required],
    superieurH: ['', Validators.required],
  });


  constructor(
    private fb: FormBuilder,
    public supervisorService: HierarchicalSupervisorService
  ) {}

  ngOnInit(): void {
    this.getAllUnity();
    this.getAllSupervisor();
  }

  public unity: any;

  public initializeForm() {
    this.form = this.fb.group({
      nom: ['', Validators.required],
      organisationalUnit: ['', Validators.required],
      superieurH: ['', Validators.required]
    });
  }

  public createSupervisor() {
    this.supervisorService.createSupervisor(this.form.value).toPromise().then(res => {
      this.response = "Enregistrement éffectuée avec succès";
      this.toggleLiveDemo();
      this.initializeForm();
      this.getAllSupervisor();
    }).catch(err => {
      this.response = "Echec, Unité déjà enregirée";
      this.toggleLiveDemo();
    })
  }

  public getAllUnity(): void{
    this.supervisorService.getAllUnity().toPromise().then(res => {
      this.listUnities = res;
      console.log(this.listUnities);
    }).catch(err => {
      console.log(err);
    }) 
  }

  public getAllSupervisor(): void{
    this.supervisorService.getAllSupervisor().toPromise().then(res => {
      this.listSupervisor = res;
      console.log(this.listSupervisor);
    }).catch(err => {
      console.log(err);
    }) 
  }

  toggleLiveDemo() {
    this.visible = !this.visible;
  }

  handleLiveDemoChange(event: any) {
    this.visible = event;
  }
}

