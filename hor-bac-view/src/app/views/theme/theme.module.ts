import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';

import { CardModule, GridModule, NavModule, UtilitiesModule, TabsModule, FormModule, ModalModule } from '@coreui/angular';
import { IconModule } from '@coreui/icons-angular';

import { TypographyComponent } from './typography.component';

// Theme Routing
import { ThemeRoutingModule } from './theme-routing.module';
import { ReactiveFormsModule } from '@angular/forms';
import { ColorsComponent } from './colors.component';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  imports: [
    CommonModule,
    ThemeRoutingModule,
    CardModule,
    GridModule,
    UtilitiesModule,
    IconModule,
    NavModule,
    TabsModule,
    FormModule,
    ReactiveFormsModule,
    ModalModule,
    HttpClientModule
  ],
  declarations: [
    ColorsComponent,
    TypographyComponent,
  ]
})
export class ThemeModule {
}
