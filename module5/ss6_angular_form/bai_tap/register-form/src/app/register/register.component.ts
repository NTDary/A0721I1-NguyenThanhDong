import { Component, OnInit } from '@angular/core';
import {IUser} from "../iuser";
import {AbstractControl, FormBuilder, FormControl, FormGroup, NgForm, Validators} from "@angular/forms";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  // Templace Form

  // cfPassword: string | undefined;
  users: IUser[] = [];
  user: IUser;
  //
  // constructor() { }
  //
  // ngOnInit(): void {
  // }
  //
  // submitForm(userForm: NgForm) {
  //   if(userForm.valid){ /* form co thoa dk ko*/
  //     this.users.push(this.user);
  //     console.log(this.users);
  //   }
  // }
  // -----Reative Form------
  register:FormGroup;

  constructor(private _formBuilder: FormBuilder) {
  }
  ngOnInit(): void {
    this.register = new FormGroup({
      userEmail : new FormControl(''),
      pwGroup: new FormGroup({
        userPass: new FormControl('',[Validators.required,Validators.minLength(6)]),
        userCPass: new FormControl('',[Validators.required])
      },comparePassword),
      userCountry: new FormControl(),
      userAge: new FormControl('',Validators.min(18)),
      userGender: new FormControl(),
      userPhone: new FormControl('',Validators.pattern(/^\+84\d{9,10}$/))
    })
  }
  get userPass(){
    return this.register.get('pwGroup').get('userPass')
  }
  get userCPass(){
    return this.register.get('pwGroup').get('userCPass')
  }

  onSubmit() {
    if(this.register.valid){
      this.users.push(this.register.value);
      this.register.reset();
    }

  }

}

function comparePassword(c: AbstractControl){
  const v = c.value;
  return (v.userPass === v.userCPass) ? null : {
    passwordnotmatch: true
  };
}
