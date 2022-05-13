import { Injectable } from '@angular/core';
import {Word} from "../model/word";

@Injectable({
  providedIn: 'root'
})
export class IWordService {

  myWord: Word[] = [
    {
      word: 'school',
      mean: 'truong'
    },
    {word: 'class',
      mean: 'lop'
    },
  ];


  constructor() { }

  getAll(){
    return this.myWord;
  }
  saveWord(addWord){
    this.myWord.push(addWord);
  }
  findById(index: number){
    return this.myWord[index];
  }
  translate(word: string){
    // for(let w of this.myWord){
    //   if(word === w.word){
    //     return w;
    //   }
    // }
    return this.myWord.find((x) => x.word == word);
  }
}
