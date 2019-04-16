import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { PostListService } from '../post-list.service';
import { User } from '../user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  results:User[];
  
  searchUser(form: NgForm) {
    let searchTokens = form.value['search'].split(" ");

    this.serv.search(searchTokens[0],searchTokens[1]).toPromise().then(data=>{this.results = data;}).then( _ =>{
      localStorage.setItem('results',JSON.stringify(this.results));
      this._router.navigate(['/search']);
    });

    // {email: '...', password: '...'}
    // ... <-- now use JSON.stringify() to convert form values to json.
  }

  constructor(private serv:PostListService, private _router:Router) { }

  ngOnInit() {
    if(!localStorage.getItem('User')){
      this._router.navigate(['/login']);
    }
  }

}
