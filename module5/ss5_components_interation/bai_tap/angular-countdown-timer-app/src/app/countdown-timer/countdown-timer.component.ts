import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-countdown-timer',
  templateUrl: './countdown-timer.component.html',
  styleUrls: ['./countdown-timer.component.css']
})
export class CountdownTimerComponent implements OnInit {
  @Input() timer;
  counter: any;
  constructor() { }

  ngOnInit(): void {
  }

  start(){
    console.log(this.timer);
    this.counter = setInterval(() => {
      this.timer--;
    }, 1000);
  }

  stop() {
    this.counter = clearInterval(this.counter);
  }

  reset() {
    this.timer = 20;
  }
}
