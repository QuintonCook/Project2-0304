import { Post } from './../post';
import { Component, OnInit, Input } from '@angular/core';
import { PostListService } from '../post-list.service';
import { User } from '../user';

@Component({
  selector: 'app-insert',
  templateUrl: './insert.component.html',
  styleUrls: ['./insert.component.css']
})
export class InsertComponent implements OnInit {

  constructor(private serv: PostListService) { }
  @Input() post = new Post();
  @Input() file: File;


  insertPost() {
    const form = new FormData();
    form.append('body', this.post.body);
    form.append('file', this.file);
    form.append('email', JSON.parse(localStorage.getItem('User')).email);
    this.serv.insertPost(form);
  }
  getFiles(event) {
    this.file = event.target.files[0];
  }
  ngOnInit() {
  }

}
