import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { POSTS } from './posts';
import {Post} from './post';
import {HttpClient} from '@angular/common/http'

const url = 'http://localhost:8080/Project2/'

@Injectable({
  providedIn: 'root'
})
export class PostListService {

  getPosts(email:String): Observable<Post[]> {
    return this.http.get<Post[]>(url+'getpost?email='+email).pipe();
  }

  constructor(private http:HttpClient) { }
}
