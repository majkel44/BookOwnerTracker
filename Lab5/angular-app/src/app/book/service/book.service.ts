import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Books } from "../model/books";
import { BookDetails } from "../model/book-details";
import { BookForm } from "../model/book-form";

/**
 * Book management service. Calls REST endpoints.
 */
@Injectable()
export class BookService {

  /**
   * @param http HTTP client
   */
  constructor(private http: HttpClient) {

  }

  /**
   * Fetches all books.
   *
   * @return list of books
   */
  getBooks(): Observable<Books> {
    return this.http.get<Books>('/api/books');
  }

  /**
   * Fetches single books.
   *
   * @param uuid book's id
   * @return single books
   */
  getBook(uuid: string): Observable<BookDetails> {
    return this.http.get<BookDetails>('/api/books/' + uuid);
  }

  /**
   * Removes single book.
   *
   * @param uuid book's id
   */
  deleteBook(uuid: string): Observable<any> {
    return this.http.delete('/api/books/' + uuid);
  }

  /**
   * Updates single book.
   *
   * @param uuid book's id
   * @param request request body
   */
  //
  putBook(uuid: string, bookForm: BookForm): Observable<Object> {
    return this.http.put('/api/books/' + uuid, bookForm);
  }

}
