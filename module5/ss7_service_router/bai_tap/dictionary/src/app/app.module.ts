import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DictionayPageComponentComponent } from './dictionay-page-component/dictionay-page-component.component';
import { DictionaryDetailComponentComponent } from './dictionary-detail-component/dictionary-detail-component.component';
import { DictionaryCreateComponentComponent } from './dictionary-create-component/dictionary-create-component.component';
import {ReactiveFormsModule} from "@angular/forms";

@NgModule({
  declarations: [
    AppComponent,
    DictionayPageComponentComponent,
    DictionaryDetailComponentComponent,
    DictionaryCreateComponentComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        ReactiveFormsModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
