import {Component, OnInit} from '@angular/core';
import {Product} from "../model/product";
import {ProductServiceService} from "../service/product-service.service";
import compile = WebAssembly.compile;
import {Subscription} from "rxjs";
import {CategoryServiceService} from "../category/service/category-service.service";
import {Category} from "../category/model/category";
import {FormBuilder, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  products: Product[] = [];
  categorys: Category[]| undefined;
  myMap = new Map();
  id: number;
  sortEd = true;
  private subcription: Subscription | undefined;

  constructor(private productService: ProductServiceService, private categoryServer: CategoryServiceService,
              private _formBuilder: FormBuilder) {
  }

  ngOnInit(): void {
    this.getAll();
    this.getAllCategory();
    // this.search();
    this.searchForm = this._formBuilder.group({
      text: ['']
      }
    )

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
  deleteProduct(id: number) {
    this.productService.deleteProduct(id).subscribe(
      () => {
        alert("Delete success")
        this.ngOnInit();
      }, e => {
        console.log(e);
      }
    )
  }

  // delete(value: number) {
  //   console.log(value);
  // }
  searchForm: FormGroup;
  setId(id: number) {
    this.id = id;
  }

  search() {
    const text = this.searchForm.value.text
    this.productService.searchProduct(text).subscribe(
      data => {
        this.products = data;
        console.log(this.products);
      },e =>{
        console.log(e);
      }
    )
  }

  sort() {
    this.sortEd = !this.sortEd;
    this.productService.sortByPrice(this.sortEd).subscribe(
      (data) => {
        if (this.sortEd) {
          this.products = data;
        } else {
          this.products = data;
        }
      }
    );
  }
}
