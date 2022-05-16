import { Component, OnInit } from '@angular/core';
import {ProductService} from '../service/product.service';
import {Product} from '../model/product';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  products: Product[];
  message: string;
  constructor(private productService: ProductService) { }

  ngOnInit(): void {
   // this.getAllList();
    this.productService.getAll().subscribe(
      data => {
        this.products = data;
        console.log(this.products);
      }
    );
  }
  getAllList() {
    // @ts-ignore
    this.productService.getAll().subscribe(
      (data) => {
        console.log(data);
        this.products = data;
      },
    );
    console.log(this.products);
  }
}
