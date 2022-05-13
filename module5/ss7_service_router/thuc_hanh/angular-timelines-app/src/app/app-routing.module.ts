import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import {TimelinesComponent} from './timelines/timelines.component';


const routes: Routes = [
  {
    path: 'timelines',
    component: TimelinesComponent

  }
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
