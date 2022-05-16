import { Component, OnInit } from '@angular/core';
import {Category} from "../model/category";
import {CategoryServiceService} from "../service/category-service.service";
import {Subscription} from "rxjs";

@Component({
  selector: 'app-category-list',
  templateUrl: './category-list.component.html',
  styleUrls: ['./category-list.component.css']
})
export class CategoryListComponent implements OnInit {

  categories: Category[] = [];

  constructor(private categoryService: CategoryServiceService) {
  }

  ngOnInit() {
    this.getAll();
  }

  getAll() {
    this.categoryService.getAll().subscribe(categories => {
      console.log(categories);
      this.categories = categories;
    });
  }

}
