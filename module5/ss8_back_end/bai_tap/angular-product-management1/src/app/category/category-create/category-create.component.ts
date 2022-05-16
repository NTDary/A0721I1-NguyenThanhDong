import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {CategoryServiceService} from "../service/category-service.service";

@Component({
  selector: 'app-category-create',
  templateUrl: './category-create.component.html',
  styleUrls: ['./category-create.component.css']
})
export class CategoryCreateComponent implements OnInit {

  createForm: FormGroup = new FormGroup({
    name: new FormControl(),
  });

  constructor(private categoryService: CategoryServiceService) {
  }

  ngOnInit() {
  }

  onSubmit() {
    const category = this.createForm.value;
    this.categoryService.saveCategory(category).subscribe(() => {
      this.createForm.reset();
      alert('Tạo thành công');
    }, e => {
      console.log(e);
    });
  }

}
