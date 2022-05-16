import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ProductServiceService} from "../service/product-service.service";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {Product} from "../model/product";
import {Subscription} from "rxjs";
import {CategoryServiceService} from "../category/service/category-service.service";

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.css']
})
export class ProductDetailComponent implements OnInit {
  editForm: FormGroup;
  product: Product;
  myMap = new Map();

  private subscription: Subscription | undefined;
  constructor(private productService: ProductServiceService, private router: Router, private _formBuilder: FormBuilder,
              private activatedRoute: ActivatedRoute,private categoryService: CategoryServiceService) { }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      const id = Number(paramMap.get('id'));
      console.log(id);
      // @ts-ignore
      this.productService.findById(id).subscribe(
        data =>{
          this.product = data;
          this.editForm.patchValue({
            id: this.product.id,
            name: this.product.name,
            price: this.product.price,
            description: this.product.description,
            category: this.product.category
          })
        }
      );
    })
    this.editForm = this._formBuilder.group({
      id: ['', Validators.required],
      name: ['', Validators.required],
      price: ['', Validators.required],
      description: ['', Validators.required],
      category: ['']
    })
    // @ts-ignore
    if(this.getAllCategory()){
      this.getAllCategory()
    }
  }

  getAllCategory(){
    this.categoryService.getAll().subscribe(
      data =>{
        const categorys = data;
        for(let i = 0; i < categorys.length ; i++){
          this.myMap.set(categorys[i].id, categorys[i].name);
        }
      }, e =>{
        console.log(e);
      }
    )
  }

  onSubmit() {
    console.log(this.editForm.value);
    this.product =this.editForm.value;
    this.product.category = +this.product.category;
    this.productService.editProduct(this.product).subscribe(data => {
      alert('Cap Nhap Thanh Cong');
      this.router.navigateByUrl("/product/list");
    });

  }
}
