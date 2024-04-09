import { Component, OnInit } from '@angular/core';
import { BookService } from "../../service/book.service";
import { Books } from "../../model/books";
import { Book } from "../../model/book";

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements OnInit{

  /**
   * @param service books service
   */
  constructor(private service: BookService) {
  }

  /**
   * Available books.
   */
  books: Books | undefined;

  ngOnInit(): void {
    this.service.getBooks().subscribe(books => this.books = books);
  }

  /**
   * Deletes selected book.
   *
   * @param book book to be removed
   */
  onDelete(book: Book): void {
    this.service.deleteBook(book.id).subscribe(() => this.ngOnInit());
  }

}
