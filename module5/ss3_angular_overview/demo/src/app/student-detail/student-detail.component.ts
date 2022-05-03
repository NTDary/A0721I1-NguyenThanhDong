import {
  AfterContentChecked,
  AfterContentInit,
  AfterViewChecked,
  AfterViewInit,
  Component,
  OnChanges,
  OnDestroy,
  OnInit, SimpleChanges
} from '@angular/core';
import {IStudent} from '../../models/IStudent';

@Component({
  selector: 'app-student-detail',
  templateUrl: './student-detail.component.html',
  styleUrls: ['./student-detail.component.css']
})
// tslint:disable-next-line:max-line-length
export class StudentDetailComponent implements OnInit, OnChanges, OnDestroy, AfterViewInit, AfterContentInit, AfterViewChecked, AfterContentChecked {
  // 1. PropertyBinding
  title = 'Coders.Tokyo';
  imageSrc = 'https://picsum.photos/200';
  withBorder = true;
  // 2. EventBinding

  // student: IStudent = {
  //   id: 1,
  //   name: 'abc',
  //   age: 5,
  //   mark: 5,
  //   avatar: 'https://picsum.photos/200',
  // };
  constructor() { }

  ngOnInit(): void {
    console.log('Oninit ran');
  }

  ngOnChanges(changes: SimpleChanges): void {
    console.log('OnChanges ran', {changes});
  }

  ngOnDestroy(): void {
    console.log('OnDestroy ran');
  }

  ngAfterViewInit(): void {
    console.log('AfterViewInit ran');
  }

  ngAfterContentInit(): void {
    console.log('AfterContentInit ran');
  }

  ngAfterContentChecked(): void {
    console.log('AfterContentChecked ran');
  }

  ngAfterViewChecked(): void {
    console.log('AfterViewChecked ran');
  }

  onButtonClick() {
    this.withBorder = !this.withBorder;
  }
}
