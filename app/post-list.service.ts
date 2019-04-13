import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import {Post} from './post';
import {HttpClient} from '@angular/common/http'
import { User } from './user';
import { NgForm } from '@angular/forms';

const url = 'http://localhost:8080/Project2/'

@Injectable({
  providedIn: 'root'
})
export class PostListService {

  login(f: NgForm): Observable<User>{
    return this.http.post<User>(url+'login', f.value).pipe();
  }

  getPosts(email:String): Observable<Post[]> {
    return this.http.get<Post[]>(url+'getpost?email='+email).pipe();
  }

  constructor(private http:HttpClient) { }
}
