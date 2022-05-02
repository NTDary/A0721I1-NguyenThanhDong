import { Component, OnInit } from '@angular/core';
import {style} from '@angular/animations';
import {inspect} from 'util';


@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {
  input = '0';
  result = '';
  constructor() { }

  ngOnInit(): void {
  }

  onButtionClick() {
    console.log('test');
  }

  pressNum(num: string) {
    // Do Not Allow . more than once
    if (this.input === '0'){
      this.input = '';
    }
    if (num === '.') {
      if (this.input !== '') {

        const lastNum = this.getLastOperand();
        console.log(lastNum.lastIndexOf('.'));
        if (lastNum.lastIndexOf('.') >= 0) { return; }
      }
    }

    if (num === '0') {
      if (this.input[0] === '0') {
        return;
      }
      const PrevKey = this.input[this.input.length - 1];
      if (PrevKey === '/' || PrevKey === '*' || PrevKey === '-' || PrevKey === '+') {
        return;
      }
    }

    this.input = this.input + num;
    this.calcAnswer();
  }

  getLastOperand() {
    let pos: number;
    console.log(this.input);
    pos = this.input.toString().lastIndexOf('+');
    if (this.input.toString().lastIndexOf('-') > pos) { pos = this.input.lastIndexOf('-'); }
    if (this.input.toString().lastIndexOf('*') > pos) { pos = this.input.lastIndexOf('*'); }
    if (this.input.toString().lastIndexOf('/') > pos) { pos = this.input.lastIndexOf('/'); }
    console.log('Last ' + this.input.substr(pos + 1));
    return this.input.substr(pos + 1);
  }

  calcAnswer() {
    let formula = this.input;

    let lastKey = formula[formula.length - 1];

    if (lastKey === '.') {
      formula = formula.substr(0, formula.length - 1);
    }

    lastKey = formula[formula.length - 1];

    if (lastKey === '/' || lastKey === '*' || lastKey === '-' || lastKey === '+' || lastKey === '.') {
      formula = formula.substr(0, formula.length - 1);
    }

    console.log('Formula ' + formula);
    // tslint:disable-next-line:no-eval
    this.result = eval(formula);
  }

  allClear() {
    this.input = '0';
    this.result = '';
  }

  clear() {
    if (this.input !== '0'){
      this.input = this.input.substr(0, this.input.length - 1);
    }
  }

  pressOperator(op: string) {
    const lastKey = this.input[this.input.length - 1];
    if (lastKey === '/' || lastKey === '*' || lastKey === '+' || lastKey === '-'){
      return;
    }
    this.input = this.input + op;
    this.calcAnswer();
  }
  getAnswer() {
    this.calcAnswer();
    this.input = this.result;
    if (this.input === '0') { this.input = ''; }
  }
}
