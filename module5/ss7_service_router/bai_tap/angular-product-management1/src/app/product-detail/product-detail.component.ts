import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ProductServiceService} from "../service/product-service.service";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {Product} from "../model/product";

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.css']
})
export class ProductDetailComponent implements OnInit {
  editForm: FormGroup;
  product: Product;
  constructor(private productService: ProductServiceService, private router: Router, private _formBuilder: FormBuilder,
              private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      const id = Number(paramMap.get('id'));
      console.log(id);
      this.product = this.productService.findById(id);
    })
    this.editForm = this._formBuilder.group({
      id: [this.product.id, Validators.required],
      name: [this.product.name, Validators.required],
      price: [this.product.price, Validators.required],
      description: [this.product.description, Validators.required],
    })
  }

  onSubmit() {
    console.log(this.editForm.value);
    this.productService.editProduct(this.editForm.value.id, this.editForm.value);
    alert('Cap Nhap Thanh Cong');
    this.router.navigateByUrl("/product/list");
    // this.editForm.patchValue({
    //   id: this.product.id,
    //   name: this.product.name,
    //   price: this.product.price,
    //   description: this.product.description,
    // })
  }
}
