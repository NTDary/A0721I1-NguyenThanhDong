import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DeleteComponent } from './delete/delete.component';
import { EditComponent } from './edit/edit.component';
import { ListComponent } from './list/list.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {ComponentService} from './services/component.service';
import {MaterialModule} from '../material/material.module';
import {APP_DATE_FORMATS, AppDateAdapter} from '../format-datepicker';
import {DateAdapter, MAT_DATE_FORMATS} from '@angular/material/core';


@NgModule({
  declarations: [DeleteComponent, EditComponent, ListComponent],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    RouterModule,
    FormsModule,
    MaterialModule
  ],
  providers: [ComponentService,
    {provide: DateAdapter, useClass: AppDateAdapter},
    {provide: MAT_DATE_FORMATS, useValue: APP_DATE_FORMATS}]
})
export class ComponentModule { }
