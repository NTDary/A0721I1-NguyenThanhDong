import { Component, OnInit } from '@angular/core';
import {IWordService} from "../service/iword.service";
import {ActivatedRoute} from "@angular/router";
import {Word} from "../model/word";

@Component({
  selector: 'app-dictionary-detail-component',
  templateUrl: './dictionary-detail-component.component.html',
  styleUrls: ['./dictionary-detail-component.component.css']
})
export class DictionaryDetailComponentComponent implements OnInit {
  wordDetail: Word | undefined;
  constructor(private wordService: IWordService, private _activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    let word = this._activatedRoute.snapshot.params['word'];
    this.wordDetail = this.wordService.translate(word);
  }

}
