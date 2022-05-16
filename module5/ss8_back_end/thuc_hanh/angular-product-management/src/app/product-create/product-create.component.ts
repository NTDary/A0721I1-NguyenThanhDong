import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {ProductService} from '../service/product.service';
import {AbstractControl, FormControl, FormGroup, ValidationErrors, Validators} from '@angular/forms';
import {Router} from '@angular/router';
@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {
  formProduct = new FormGroup({
    id: new FormControl('', [Validators.required]),
    name: new FormControl(),
    price: new FormControl(),
    description: new FormControl()
  });
  constructor(private productService: ProductService, private router: Router) { }

  ngOnInit(): void {
    console.log(this.productService.getAll());
  }

  get id(){
    return this.formProduct.get('id');
  }


  submit() {
    this.productService.saveProduct(this.formProduct.value);
    this.router.navigateByUrl('/product/list');
  }

  //  gte(control: AbstractControl): ValidationErrors  {
  //   // tslint:disable-next-line:label-position no-unused-expression prefer-const
  //   // let productService: ProductService;
  //   const v = control.value;
  //   console.log(v);
  //   // tslint:disable-next-line:prefer-for-of
  //     // tslint:disable-next-line:prefer-for-of
  //   console.log(this._productService.getAll());
  //   for (let i = 0; i < this._productService.products.length ; i++) {
  //       if (v === this._productService.products[i].id) {
  //         return {gte : true, requiredValue : 'Id exist' };
  //       }
  //     }
  // }
}
