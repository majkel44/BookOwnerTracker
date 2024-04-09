import { Component, OnInit } from '@angular/core';
import { BookService } from '../../service/book.service';
import { ActivatedRoute, Router } from '@angular/router';
import { BookForm } from '../../model/book-form';
import { OwnerService } from "../../../owner/service/owner.service";
import { Owners } from "../../../owner/model/owners";

@Component({
  selector: 'app-book-edit',
  templateUrl: './book-edit.component.html',
  styleUrls: ['./book-edit.component.css']
})
export class BookEditComponent implements OnInit {

  /**
   * Book's id.
   */
  uuid: string | undefined;

  /**
   * Single book.
   */
  book: BookForm | undefined;

  /**
   * Single book.
   */
  original: BookForm | undefined;

  /**
   * Available owners.
   */
  owners: Owners | undefined;

  /**
   * @param bookService book service
   * @param ownerService owner service
   * @param route activated route
   * @param router router
   */
  constructor(
    private bookService: BookService,
    private ownerService: OwnerService,
    private route: ActivatedRoute,
    private router: Router
  ) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.ownerService.getOwners()
        .subscribe(owners => this.owners = owners);

      this.bookService.getBook(params['uuid'])
        .subscribe(book => {
          this.uuid = book.id;
          this.book = {
            title: book.title,
            number_of_pages: book.number_of_pages,
            owner: book.owner.id
          };
          this.original = {...this.book};
        });
    });
  }

  /**
   * Updates book.
   */
  onSubmit(): void {
    this.bookService.putBook(this.uuid!, this.book!)
      .subscribe(() => this.router.navigate(['/books']));
  }

}
