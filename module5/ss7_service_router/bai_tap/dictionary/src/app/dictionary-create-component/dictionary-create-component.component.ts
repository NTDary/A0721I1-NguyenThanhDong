import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {IWordService} from "../service/iword.service";

@Component({
  selector: 'app-dictionary-create-component',
  templateUrl: './dictionary-create-component.component.html',
  styleUrls: ['./dictionary-create-component.component.css']
})
export class DictionaryCreateComponentComponent implements OnInit {
  wordForm: FormGroup;

  constructor(private _formBuilder: FormBuilder, private wordService: IWordService) { }

  ngOnInit(): void {
    this.wordForm = this._formBuilder.group({
      word: [''],
      mean:['']
    })
  }

  submit() {
    const newWord = this.wordForm.value;
    this.wordService.saveWord(newWord)
    this.wordForm.reset();
  }
}
