import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, UrlSegment, Router } from '@angular/router';
import { Location } from '@angular/common';
@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

currUrl: string;

  constructor(r: ActivatedRoute, loc: Location, route: Router) {
    route.events.subscribe(val => {
      if (loc.path() !== '') {
          this.currUrl = loc.path();
      } else {
       this.currUrl = 'Home';
      }
    });
    console.log(route.url);
    console.log(loc.path());
    console.log(r.url);
   }

  ngOnInit() {
  }

}
