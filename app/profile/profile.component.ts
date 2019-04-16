import { HomepageComponent } from './../homepage/homepage.component';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, UrlSegment, Router } from '@angular/router';
import { Location, JsonPipe } from '@angular/common';
import { User } from '../user';
import { PostListService } from '../post-list.service';
import { Post } from '../post';
@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  currUrl: string;
  posts: Post[] = [];
  user: User;
  constructor( private route: ActivatedRoute,
               private loc: Location, private serv: PostListService) {
    }



    ngOnInit() {
      const email = this.route.params.subscribe(email => {this.serv.getUser(email.email).toPromise().then(data => {
        this.user = data;
        console.log(this.user);
      }); });
    }

    like(p: Post) {
      p.numberOfLikes = p.numberOfLikes + 1;
      this.serv.likePost(p.postId);
    }
}
