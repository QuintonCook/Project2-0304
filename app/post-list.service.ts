import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { POSTS } from './posts';
import {Post} from './post';

@Injectable({
  providedIn: 'root'
})
export class PostListService {

  getPosts(): Observable<Post[]> {
    return of(POSTS);
  }

  constructor() { }
}