import { Component, OnInit } from '@angular/core';
import { BookService } from '../../service/book.service';
import { ActivatedRoute, Router } from '@angular/router';
import { BookForm } from '../../model/book-form';
import { OwnerService } from "../../../owner/service/owner.service";
import { Owners } from "../../../owner/model/owners";
import {Owner} from "../../../owner/model/owner";

@Component({
  selector: 'app-book-add',
  templateUrl: './book-add.component.html',
  styleUrls: ['./book-add.component.css']
})
export class BookAddComponent implements OnInit {

  /**
   * Book's id.
   */
  uuid: string | undefined;

  /**
   * Single book.
   */
  book: BookForm;

  /**
   * Single book.
   */
  owner: Owner | undefined;

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
    this.book = {
      title:'',
      number_of_pages: 0,
      owner: '',
    }
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.ownerService.getOwners()
        .subscribe(owners => this.owners = owners);
    });

    this.route.params.subscribe(params => {
      this.ownerService.getOwner(params['uuid'])
        .subscribe(owner => {
          this.uuid = owner.id;
          this.owner = {
            id: owner.id,
            name: owner.name,
            age: owner.age,
          };
          this.book.owner = this.owner.id;
        });
    });


    this.uuid = 'f5875513-bf7b-4ae1-b8a5-5b70a1b90333';
  }

  /**
   * Updates book.
   */
  onSubmit(): void {
    this.bookService.putBook(this.uuid!, this.book!)
      .subscribe(() => this.router.navigate(['/books']));
  }

}
