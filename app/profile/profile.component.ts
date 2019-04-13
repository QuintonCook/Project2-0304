import { HomepageComponent } from './../homepage/homepage.component';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, UrlSegment, Router } from '@angular/router';
import { Location } from '@angular/common';
import { User } from '../user';
import { PostListService } from '../post-list.service';
@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  currUrl: string;
  
  user:User;

  constructor( private route: ActivatedRoute,
               private loc: Location, private serv:PostListService) {
    }



    ngOnInit() {
      this.user = JSON.parse(localStorage.getItem('User'));
      this.getEmail();
      console.log(this.user);
    }
    getEmail() {
      const email = this.route.snapshot.paramMap.get('email');

      if(email !== this.user.email){
        this.serv.getUser(email).subscribe(data =>{
          this.user = data;
        });
      }
      
    }
}
