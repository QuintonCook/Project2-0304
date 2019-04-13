import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { PostListService } from '../post-list.service';
import { User } from '../user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user: User;
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

  constructor(private _router: Router, private loc: Location, private serv: PostListService) {

  }


  toggle(form: NgForm) {
    this.serv.login(form).subscribe(data => {this.user=data});

    if(this.user){
      localStorage.setItem('User', JSON.stringify(this.user));
      this._router.navigate(['/header']);
    }

    else{
      alert("it no work");
    }




    /*
    //PostListService.login();
    //this._router.navigate(['/header']);
    this.show = !this.show;
    console.log(form.value);

    // CHANGE THE NAME OF THE BUTTON.
    if(!this.show) { 
      this._router.navigate(['/header']);
    }
    */


  }

  ngOnInit() {
  }

}
