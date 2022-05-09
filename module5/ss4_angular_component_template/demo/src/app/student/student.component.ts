import { Component, OnInit } from '@angular/core';
import {Student} from '../student';
import {StudentService} from '../service/student.service';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {
  student: Student;
  students: Student[];
  ngOnInit(): void {
    this.students = this._studentService.students;
  }
  // DI
  // tslint:disable-next-line:variable-name
  constructor(private _studentService: StudentService) {}

  showDetail(s: Student) {
    this.student = s;
  }

  addStudent(value: Student) {
    this._studentService.save(value);
  }
}
