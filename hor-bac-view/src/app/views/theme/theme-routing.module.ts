import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ColorsComponent } from './colors.component';
import { TypographyComponent } from './typography.component';

const routes: Routes = [
  {
    path: '',
    data: {
      title: 'Theme',
    },
    children: [
      {
        path: '',
        redirectTo: 'new',
      },
      {
        path: 'new',
        component: ColorsComponent,
        data: {
          title: 'new',
        },
      },
      {
        path: 'list',
        component: TypographyComponent,
        data: {
          title: 'list',
        },
      },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ThemeRoutingModule {}
