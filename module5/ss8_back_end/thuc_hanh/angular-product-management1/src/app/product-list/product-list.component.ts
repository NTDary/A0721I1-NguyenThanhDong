import {Component, OnInit} from '@angular/core';
import {Product} from "../model/product";
import {ProductServiceService} from "../service/product-service.service";
import compile = WebAssembly.compile;
import {Subscription} from "rxjs";

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  products: Product[] = [];
  private subcription: Subscription | undefined;

  constructor(private productService: ProductServiceService) {
  }

  ngOnInit(): void {
    console.log("alo")
    this.getAll();
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
