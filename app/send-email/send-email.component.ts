import { PostListService } from './../post-list.service';
import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-send-email',
  templateUrl: './send-email.component.html',
  styleUrls: ['./send-email.component.css']
})
export class SendEmailComponent implements OnInit {

@Input() email: string;
  constructor(private serv: PostListService) { }

  ngOnInit() {
  }

  sendEmail() {
    this.serv.sendEmail(this.email);
  }
}
