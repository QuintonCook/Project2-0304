import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import {Post} from './post';
import {HttpClient} from '@angular/common/http';
import { User } from './user';
import { NgForm } from '@angular/forms';

const url = 'http://localhost:8080/Project2/';

@Injectable({
  providedIn: 'root'
})
export class PostListService {

  login(f: NgForm): Observable<User> {
    return this.http.post<User>(url + 'login', f.value).pipe();
  }

  getPosts(email: string): Observable<Post[]> {
    return this.http.get<Post[]>(url + 'getpost?email=' + email).pipe();
  }

  insertUser(form: NgForm) {
    this.http.post(url + 'register', form.value).subscribe();
  }
  insertPost(form: FormData) {
    this.http.post(url + 'insertpost', form).subscribe();
  }
  likePost(id: number) {
    this.http.get(url + 'likepost?id=' + id).subscribe();
  }

  getUser(email: string): Observable<User> {
    return this.http.get<User>(url + 'searchuseremail?email=' + email).pipe();
  }

  search(first: string, last: string): Observable<User[]> {
    return this.http.get<User[]>(url + 'searchuser?first=' + first + '&last=' + last).pipe();
  }

  updateProfile(form: FormData) {
    this.http.post(url + 'updateprofile', form).subscribe();
  }
  getAllPosts(): Observable<Post[]> {
    return this.http.get<Post[]>(url + 'allposts').pipe();
  }
  sendEmail(email: string) {
    this.http.get(url + 'reset?email=' + email).subscribe();
  }
  whatever2(email: string, password: string) {
    console.log(email);
    console.log(password);
    this.http.get(url + 'passwordreset?email=' + email + '&password=' + password).subscribe();
  }
  constructor(private http: HttpClient) { }
}
