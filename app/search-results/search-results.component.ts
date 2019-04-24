import { Component, OnInit } from '@angular/core';
import { User } from '../user';

@Component({
  selector: 'app-search-results',
  templateUrl: './search-results.component.html',
  styleUrls: ['./search-results.component.css']
})
export class SearchResultsComponent implements OnInit {

  results:User[];
  constructor() { }

  ngOnInit() {
    //console.log(JSON.parse(localStorage.getItem('results')));
    this.results = JSON.parse(localStorage.getItem('results'));
  }

}
