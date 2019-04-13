import { PostListService } from './../post-list.service';
import { Post } from './../post';
import { Component, OnInit } from '@angular/core';
@Component({
  selector: 'app-feed',
  templateUrl: './feed.component.html',
  styleUrls: ['./feed.component.css']
})
export class FeedComponent implements OnInit {

  posts: Post[] = [];

  constructor( private serv: PostListService) {
                 this.serv.getPosts('Quinton_Cook@gamil.com').subscribe(posts => this.posts = posts);
    }
    ngOnInit() {
    }
}
