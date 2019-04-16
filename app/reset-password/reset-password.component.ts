import { PostListService } from './../post-list.service';
import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-reset-password',
  templateUrl: './reset-password.component.html',
  styleUrls: ['./reset-password.component.css']
})
export class ResetPasswordComponent implements OnInit {

  @Input() email: string;
  @Input() password: string;
  constructor(private serv: PostListService) { }

  ngOnInit() {
  }

  whatever() {
    this.serv.whatever2(this.email, this.password);
  }
}
