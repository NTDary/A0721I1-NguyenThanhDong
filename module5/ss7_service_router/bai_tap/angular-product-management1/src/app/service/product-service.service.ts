import { Injectable } from '@angular/core';
import {Product} from "../model/product";

@Injectable({
  providedIn: 'root'
})
export class ProductServiceService {
  products: Product[] = [{
    id: 1,
    name: 'IPhone 12',
    price: 2400000,
    description: 'New'
  }, {
    id: 2,
    name: 'IPhone 11',
    price: 1560000,
    description: 'Like new'
  }, {
    id: 3,
    name: 'IPhone X',
    price: 968000,
    description: '97%'
  }, {
    id: 4,
    name: 'IPhone 8',
    price: 7540000,
    description: '98%'
  }, {
    id: 5,
    name: 'IPhone 11 Pro',
    price: 1895000,
    description: 'Like new'
  }];
  constructor() { }

  getAll(){
    return this.products;
  }
  saveProduct(product){
    this.products.push(product);
  }
  findById(id: number){
    return this.products.find((p) =>  p.id === id);
  }
  editProduct(id: number,product: Product){
    for(let i = 0; i < this.products.length; i++){
      if(this.products[i].id === id){
        this.products[i] = product;
      }
    }
  }
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
