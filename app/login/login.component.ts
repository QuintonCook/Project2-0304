import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public show:boolean = true;

  registerUser(form: NgForm) {
    console.log(form.value);
    // {email: '...', password: '...'}
    // ... <-- now use JSON.stringify() to convert form values to json.
  }

  loginUser(form: NgForm) {
    console.log(form.value);
    // {email: '...', password: '...'}
    // ... <-- now use JSON.stringify() to convert form values to json.
  }

  constructor(private _router: Router, private loc: Location) {

  }

  toggle() {
    //this._router.navigate(['/header']);
    this.show = !this.show;

    // CHANGE THE NAME OF THE BUTTON.
    if(!this.show) { 
      this._router.navigate(['/header']);
    }
  }

  ngOnInit() {
  }

}
