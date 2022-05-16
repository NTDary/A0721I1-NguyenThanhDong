import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ProductServiceService} from "../service/product-service.service";
import {Product} from "../model/product";
import {Router} from "@angular/router";
import {Subscription} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {CategoryServiceService} from "../category/service/category-service.service";
import {Category} from "../category/model/category";

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {
  createForm: FormGroup;
  categorys: Category[];
  private subcription: Subscription;

  constructor(private productService: ProductServiceService, private _formBuilder: FormBuilder, private router: Router,
              private categoryServer: CategoryServiceService) {
  }

  ngOnInit(): void {
    this.getAllCategory();
    this.createForm = this._formBuilder.group({
      id: [''],
      name: ['', [Validators.required, Validators.minLength(6)]],
      price: [''],
      description: [''],
      category: ['']
    })
  }

  get name() {
    return this.createForm.get('name');
  }

  getAllCategory(){
    this.categoryServer.getAll().subscribe(
      data =>{
        this.categorys = data;
      },e =>{
        console.log(e);
      }
    )
  }

  onSubmit() {
    if(this.createForm.valid){
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
    }

    // this.productService.saveProduct(this.createForm.value);

  }
}
