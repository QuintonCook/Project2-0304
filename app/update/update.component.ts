import { Component, OnInit, Input } from '@angular/core';
import { NgForm } from '@angular/forms';
import { User } from '../user';
import { PostListService } from '../post-list.service';


@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {
  @Input() user = new User();
  @Input() file:File;
  
  updateUser() {

    console.log(JSON.stringify(this.user));

    let form = new FormData();
    for (var key in this.user) {
      if (this.user.hasOwnProperty(key)) {
        form.append(key,this.user[key]);
      }
    }

    form.append('file',this.file);
   
    
    this.serv.updateProfile(form);

    // {email: '...', password: '...'}
    // ... <-- now use JSON.stringify() to convert form values to json.
  }

  getFiles(event){
    this.file = event.target.files[0];
  }

  constructor(private serv:PostListService) { }

  ngOnInit() {
  }

}
