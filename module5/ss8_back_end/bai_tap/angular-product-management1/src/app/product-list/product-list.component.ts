import {Component, OnInit} from '@angular/core';
import {Product} from "../model/product";
import {ProductServiceService} from "../service/product-service.service";
import compile = WebAssembly.compile;
import {Subscription} from "rxjs";
import {CategoryServiceService} from "../category/service/category-service.service";
import {Category} from "../category/model/category";

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  products: Product[] = [];
  categorys: Category[]| undefined;
  myMap = new Map();
  private subcription: Subscription | undefined;

  constructor(private productService: ProductServiceService, private categoryServer: CategoryServiceService) {
  }

  ngOnInit(): void {
    this.getAll();
    this.getAllCategory();

  }

  getAllCategory(){
    this.categoryServer.getAll().subscribe(
      data =>{
      this.categorys = data;
        for(let i = 0; i < this.categorys.length; i++){
          this.myMap.set(this.categorys[i].id,this.categorys[i].name);
        }
      },e =>{
        console.log(e);
      }
    )
  }

  getAll() {
    this.subcription = this.productService.getAll().subscribe(
      data => {
        this.products = data;
        console.log(data);
      },
      error => {
        console.log('khong lay dc list')
       },
      // () => {
      //
      // }
    );
  }
}
