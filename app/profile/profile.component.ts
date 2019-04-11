import { HomepageComponent } from './../homepage/homepage.component';
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

  constructor( private route: ActivatedRoute,
               private loc: Location) {
      this.getEmail();
    }



    ngOnInit() {
    }
    getEmail() {
      const email = +this.route.snapshot.paramMap.get('email');
      // this.hService.getPatriot(id).subscribe(patriot => this.patriot = patriot);

    }
}
