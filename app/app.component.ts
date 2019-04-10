import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Practice';

  showText(title:string) {
    if(title!="")
  {
     alert(title);
  }
  else
  {
   alert("Fill the name first!!!");
  }
  }



}
