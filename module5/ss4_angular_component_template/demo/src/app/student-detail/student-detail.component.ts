import {Component, Input, OnInit} from '@angular/core';
import {Student} from '../student';

@Component({
  selector: 'app-student-detail',
  templateUrl: './student-detail.component.html',
  styleUrls: ['./student-detail.component.css']
})
export class StudentDetailComponent implements OnInit {
  // tslint:disable-next-line:no-input-rename
  // Cách dùng một tên khác thay biến
  // @Input('inputStudent') studentDetail: Student;
  // Cách dùng tên biến
  @Input() studentDetail: Student;

  constructor() { }

  ngOnInit(): void {
  }

}
