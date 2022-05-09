import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {IRating} from '../irating';

@Component({
  selector: 'app-rating-bar',
  templateUrl: './rating-bar.component.html',
  styleUrls: ['./rating-bar.component.css']
})
export class RatingBarComponent implements OnInit {
  @Output() ratingEvent = new EventEmitter<string>();
  rating: IRating[] = [
    {
      value: '1',
      active: false
    },
    {
      value: '2',
      active: false
    },
    {
      value: '3',
      active: false
    },
    {
      value: '4',
      active: false
    },
    {
      value: '5',
      active: false
    },
    {
      value: '6',
      active: false
    },
    {
      value: '7',
      active: false
    },
    {
      value: '8',
      active: false
    },
    {
      value: '9',
      active: false
    },
    {
      value: '10',
      active: false
    },
    ];
  constructor() { }

  ngOnInit(): void {

  }

  choose(value: string) {
    // tslint:disable-next-line:prefer-for-of
    // for (let i = 0 ; i < this.rating.length ; i++){
    //   this.rating[i].active = false;
    //   // tslint:disable-next-line:triple-equals
    //   if (this.rating[i].value == value){
    //     for (let j = 0 ; j <= i ; j++){
    //       console.log(j);
    //       this.rating[j].active = true;
    //     }
    //   }
    // }
    this.ratingEvent.emit(value);
    // tslint:disable-next-line:radix
    for (let i = 0; i < parseInt(value); i++) {
      this.rating[i].active = true;
    }
    for (let i = parseInt(value); i < 10; i++) {
      this.rating[i].active = false;
    }
  }

}
