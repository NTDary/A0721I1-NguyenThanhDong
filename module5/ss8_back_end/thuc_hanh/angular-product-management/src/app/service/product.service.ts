import { Injectable } from '@angular/core';
import {Product} from '../model/product';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

const API_URL = 'http://localhost:3000/products';
@Injectable({
  providedIn: 'root'
})

export class ProductService {
  products: Product[] = [];
  constructor(private http: HttpClient) { }
  getAll(): Observable<Product[]>{
    return this.http.get<Product[]>(API_URL);
  }
  saveProduct(product: Product) {
    let check = true;
    let j: number;
    for (let i = 0; i < this.products.length; i++) {
      if (this.products[i].id === product.id) {
        check = false;
        j = i;
        break;
      }
    }
    if (check) {
      this.products.push(product);
    } else {
      this.products[j] = product;
    }
  }
  // @ts-ignore
  findById(id: number): Product {
    return this.products.find((product) => product.id === id);
  }
  updateProduct(id: number, product: Product){
    // tslint:disable-next-line:prefer-for-of
   for (let i = 0; i < this.products.length; i++){
     if (this.products[i].id === id) {
       this.products[i] = product;
     }
   }
  }
  // deleteProduct(id: number){
  //   for (let i = 0; i <= this.products.length; i++) {
  //     if (this.products[i].id === id) {
  //       this.pr
  //     }
  //   }
  // }
  deleteProduct(id: number) {
    // Lấy ra những product có id khắc vs id truyền vào
    // Cách 1
    this.products = this.products.filter(product => {
      return product.id !== id;
    });
    // Cách 2
    // tslint:disable-next-line:prefer-for-of
    // for (let i = 0; i < this.products.length ; i++){
    //   if (this.products[i].id === id){
    //     this.products.slice(i, 1);
    //   }
    // }
  }
}
