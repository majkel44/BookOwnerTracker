import { Component, OnInit } from '@angular/core';
import { BookService } from "../../service/book.service";
import { ActivatedRoute, Router } from "@angular/router";
import { BookDetails } from "../../model/book-details";

/**
 * Preview of single book.
 */
@Component({
  selector: 'app-book-view',
  templateUrl: './book-view.component.html',
  styleUrls: ['./book-view.component.css']
})
export class BookViewComponent implements OnInit {

  /**
   * Single book.
   */
  book: BookDetails | undefined;

  /**
   *
   * @param service book service
   * @param route activated route
   * @param router router
   */
  constructor(private service: BookService, private route: ActivatedRoute, private router: Router) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.service.getBook(params['uuid'])
        .subscribe(book => this.book = book)
    });
  }

}
