import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ProductServiceService} from "../service/product-service.service";
import {Product} from "../model/product";
import {Router} from "@angular/router";

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {
  createForm: FormGroup;

  constructor(private productService: ProductServiceService, private _formBuilder: FormBuilder, private router: Router) { }

  ngOnInit(): void {
    this.createForm = this._formBuilder.group({
      id: ['',[Validators.required]],
      name: ['',[Validators.required, Validators.minLength(6)]],
      price: ['',[Validators.required]],
      description: ['']
    })
  }

  get name(){
    return this.createForm.get('name');
  }
  onSubmit() {
    this.productService.saveProduct(this.createForm.value);
    this.router.navigateByUrl('/product/list')
  }
}
