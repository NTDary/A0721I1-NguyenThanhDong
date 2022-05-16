import {Injectable} from '@angular/core';
import {Product} from "../model/product";
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ProductServiceService {
  private API_URL = "http://localhost:3000/products";
  products: Product[] = [
    //   {
    //   id: 1,
    //   name: 'IPhone 12',
    //   price: 2400000,
    //   description: 'New'
    // }, {
    //   id: 2,
    //   name: 'IPhone 11',
    //   price: 1560000,
    //   description: 'Like new'
    // }, {
    //   id: 3,
    //   name: 'IPhone X',
    //   price: 968000,
    //   description: '97%'
    // }, {
    //   id: 4,
    //   name: 'IPhone 8',
    //   price: 7540000,
    //   description: '98%'
    // }, {
    //   id: 5,
    //   name: 'IPhone 11 Pro',
    //   price: 1895000,
    //   description: 'Like new'
    // }
  ];

  constructor(private _httpClient: HttpClient) {
  }


  /*Lay danh sach*/
  getAll(): Observable<Product[]> {
    return this._httpClient.get<Product[]>(this.API_URL);
  }

  // @ts-ignore
  saveProduct(product: Product): Observable<Product> {
    return this._httpClient.post<Product>(this.API_URL, product);
    // this.products.push(product);
  }

 /* findById(id: number) {
    return this.products.find((p) => p.id === id);
  }*/
  findById(id: number): Observable<Product> {
    return this._httpClient.get<Product>(this.API_URL + '/' + id);
  }

  //edit theo du lieu cung
/*  editProduct(id: number, product: Product) {
    // edit du lieu cung
    for (let i = 0; i < this.products.length; i++) {
      if (this.products[i].id === id) {
        this.products[i] = product;
      }
    }
  }*/
  //edit theo backend

  editProduct(product: Product): Observable<void> {
    return this._httpClient.patch<void>(this.API_URL + '/' + product.id, product);
  }

  deleteProduct(id: number): Observable<Product> {
    // Lấy ra những product có id khắc vs id truyền vào
    /*    // Cách 1
        this.products = this.products.filter(product => {
          return product.id !== id;
        });*/
    /*    // Cách 2
        // tslint:disable-next-line:prefer-for-of
        for (let i = 0; i < this.products.length ; i++){
          if (this.products[i].id === id){
            this.products.slice(i, 1);
          }
        }*/
    //Cach 3: ket noi backend
    return this._httpClient.delete(this.API_URL + '/' + id)

  }
}
