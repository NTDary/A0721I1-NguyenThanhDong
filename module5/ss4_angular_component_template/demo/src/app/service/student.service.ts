import { Injectable } from '@angular/core';
import {Student} from '../student';

@Injectable({
  providedIn: 'root'
})
export class StudentService {
  private _students: Student[] = [
    {
      name: 'Nguyen Van A', gender: 0, point: 100
    },
    {
      name: 'Nguyen Van B', gender: 1, point: 80
    },
    {
      name: 'Nguyen Van C', gender: 2, point: 50
    },
    {
      name: 'Nguyen Van D', gender: 1, point: 20
    }, {
      name: 'Nguyen Van F', gender: 1, point: 0
    }
  ];

  constructor() { }


  get students(): Student[] {
    return this._students;
  }

  set students(value: Student[]) {
    this._students = value;
  }

  save(student: Student){
    this._students.unshift(student);
  }
}
