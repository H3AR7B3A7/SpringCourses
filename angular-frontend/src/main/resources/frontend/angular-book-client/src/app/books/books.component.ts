import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.css']
})
export class BooksComponent implements OnInit {

  books:any;

  constructor(private http:HttpClient) { }

  ngOnInit(): void {
    let response = this.http.get("http://localhost:8080/api/books");
    response.subscribe((data)=>this.books=data)
  }

}
