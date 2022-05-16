import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ProductListComponent} from "./product-list/product-list.component";
import {ProductCreateComponent} from "./product-create/product-create.component";
import {ProductDeleteComponent} from "./product-delete/product-delete.component";
import {ProductDetailComponent} from "./product-detail/product-detail.component";
import {CategoryListComponent} from "./category/category-list/category-list.component";
import {CategoryCreateComponent} from "./category/category-create/category-create.component";
import {CategoryEditComponent} from "./category/category-edit/category-edit.component";
import {CategoryDeleteComponent} from "./category/category-delete/category-delete.component";


const routes: Routes = [
  {path: 'product/list', component: ProductListComponent},
  {path: 'product/create', component: ProductCreateComponent},
  {path: 'product/edit/:id', component: ProductDetailComponent},
  {path: 'product/delete/:id', component: ProductDeleteComponent},
  {path: 'category/list', component: CategoryListComponent},
  {path: 'category/create', component: CategoryCreateComponent},
  {path: 'category/edit/:id', component: CategoryEditComponent},
  {path: 'category/delete/:id', component: CategoryDeleteComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
