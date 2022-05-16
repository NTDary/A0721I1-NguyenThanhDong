import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {EditComponent} from './component/edit/edit.component';
import {DeleteComponent} from './component/delete/delete.component';
import {ListComponent} from './component/list/list.component';

const routes: Routes = [
  {
    path: '', children: [
      {path: 'edit/:id', component: EditComponent},
      {path: 'delete/:id', component: DeleteComponent},
      {path: 'list', component: ListComponent}
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
