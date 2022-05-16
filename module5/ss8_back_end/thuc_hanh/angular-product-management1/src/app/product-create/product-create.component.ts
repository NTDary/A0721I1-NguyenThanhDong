import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ProductServiceService} from "../service/product-service.service";
import {Product} from "../model/product";
import {Router} from "@angular/router";
import {Subscription} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {
  createForm: FormGroup;
  private subcription: Subscription;

  constructor(private productService: ProductServiceService, private _formBuilder: FormBuilder, private router: Router) {
  }

  ngOnInit(): void {
    this.createForm = this._formBuilder.group({
      id: ['', [Validators.required]],
      name: ['', [Validators.required, Validators.minLength(6)]],
      price: ['', [Validators.required]],
      description: ['']
    })
  }

  get name() {
    return this.createForm.get('name');
  }

  onSubmit() {
    const product = this.createForm.value;

    this.subcription = this.productService.saveProduct(product).subscribe(data => {
        this.createForm.reset();
        alert('Create thanh cong');
        console.log(data);
      },
      e => {
        console.log(e);
      }, () =>{
        this.router.navigateByUrl('/product/list')
      }
    )
    // this.productService.saveProduct(this.createForm.value);

  }
}
