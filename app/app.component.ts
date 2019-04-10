import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Proj2';

  showText(title:string, title1:string) {
    if(title!="" && title1 !="")
  {
     //alert(title);
     console.log(title);
     console.log(title1);
  }
  else
  {
   alert("Missing credentials!");
  }
  }

  getText(first:string, last:string, email:string, pass:string){
    if(first!="" && last!="" && email!="" && pass!=""){
      console.log(first);
      console.log(last);
      console.log(email);
      console.log(pass);
    }
    else{
      alert("Missing fields!");
    }
  }

}
