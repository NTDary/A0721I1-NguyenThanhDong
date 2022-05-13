import { Component, OnInit } from '@angular/core';
import {ProductService} from '../service/product.service';
import {Product} from '../model/product';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  products: Product[] = [];
  message: string;
  constructor(private productService: ProductService) { }

  ngOnInit(): void {
   this.getAllList();
  }
  getAllList() {
    this.products = this.productService.getAll();
  }
}
