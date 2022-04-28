import { Component, OnInit } from '@angular/core';
import {IStudent} from '../../models/IStudent';

@Component({
  selector: 'app-student-detail',
  templateUrl: './student-detail.component.html',
  styleUrls: ['./student-detail.component.css']
})
export class StudentDetailComponent implements OnInit {

  student: IStudent = {
    id: 1,
    name: 'abc',
    age: 5,
    mark: 5,
    avatar: 'https://picsum.photos/200',
  };
  constructor() { }

  ngOnInit(): void {
  }

}
