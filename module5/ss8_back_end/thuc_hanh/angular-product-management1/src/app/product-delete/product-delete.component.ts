import {Component, OnInit} from '@angular/core';
import {ProductServiceService} from "../service/product-service.service";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {Subscription} from "rxjs";

@Component({
  selector: 'app-product-delete',
  templateUrl: './product-delete.component.html',
  styleUrls: ['./product-delete.component.css']
})
export class ProductDeleteComponent implements OnInit {
  private subscription: Subscription | undefined;

  constructor(private productService: ProductServiceService, private router: Router, private activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      const id = +paramMap.get('id');
      this.deleteProduct(id);
      // this.productService.deleteProduct(parseInt(id));
      // this.router.navigateByUrl("/product/list");
    })
  }

  deleteProduct(id: number) {
    this.subscription = this.productService.deleteProduct(id).subscribe(
      () => {
        alert("Delete success")
        this.router.navigateByUrl("/product/list");
      }, e => {
        console.log(e);
      }
    )
  }

}
