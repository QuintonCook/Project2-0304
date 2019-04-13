import { PostListService } from './../post-list.service';
import { Post } from './../post';
import { Component, OnInit } from '@angular/core';
import { User } from '../user';
@Component({
  selector: 'app-feed',
  templateUrl: './feed.component.html',
  styleUrls: ['./feed.component.css']
})
export class FeedComponent implements OnInit {

  
  posts: Post[] = [];
  user:User;

  constructor( private serv: PostListService) {}

    ngOnInit() {
      this.user = JSON.parse(localStorage.getItem('User'));
      this.serv.getPosts(this.user.email).subscribe(posts => this.posts = posts);
    }

    like(p:Post){
      p.numberOfLikes = p.numberOfLikes+1;
      this.serv.likePost(p.postId);
    }
}
