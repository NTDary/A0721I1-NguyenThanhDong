import { Component, OnInit } from '@angular/core';
import {Word} from "../model/word";
import {IWordService} from "../service/iword.service";

@Component({
  selector: 'app-dictionay-page-component',
  templateUrl: './dictionay-page-component.component.html',
  styleUrls: ['./dictionay-page-component.component.css']
})
export class DictionayPageComponentComponent implements OnInit {
  myWord: Word[] = [];

  constructor(private wordService: IWordService) { }

  ngOnInit(): void {
    this.getAll();
  }
  getAll(){
    this.myWord = this.wordService.getAll();
  }
}
