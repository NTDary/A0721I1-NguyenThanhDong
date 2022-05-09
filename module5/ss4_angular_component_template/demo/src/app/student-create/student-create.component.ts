import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {Student} from '../student';

@Component({
  selector: 'app-student-create',
  templateUrl: './student-create.component.html',
  styleUrls: ['./student-create.component.css']
})
export class StudentCreateComponent implements OnInit {
  @Output() newStudent = new EventEmitter<Student>();

  student: Student | undefined;

  constructor() { }

  ngOnInit(): void {
  }

  createStudent(name: string, gender: string, point: string) {
    // tslint:disable-next-line:radix
    this.student = {name, gender: parseInt(gender), point: parseInt(point)};
    console.log(this.student);
    this.newStudent.emit(this.student);
    
  }
}
