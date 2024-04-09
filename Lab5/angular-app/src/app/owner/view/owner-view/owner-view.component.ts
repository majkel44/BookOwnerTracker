import { Component, OnInit } from '@angular/core';
import { OwnerService } from "../../service/owner.service";
import { ActivatedRoute, Router } from "@angular/router";
import { OwnerDetails } from "../../model/owner-details";
import {Book} from "../../../book/model/book";

/**
 * Preview of single book.
 */
@Component({
  selector: 'app-owner-view',
  templateUrl: './owner-view.component.html',
  styleUrls: ['./owner-view.component.css']
})
export class OwnerViewComponent implements OnInit {

  /**
   * Single book.
   */
  owner: OwnerDetails | undefined;
  books: any;

  /**
   *
   * @param service book service
   * @param route activated route
   * @param router router
   */
  constructor(private ownerService: OwnerService, private route: ActivatedRoute, private router: Router) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.ownerService.getOwner(params['uuid'])
        .subscribe(owner => this.owner = owner);
      this.ownerService.getOwnerBooks(params['uuid']).subscribe(books => this.books = books);
    });
  }

  onDelete(book: Book): void {
    this.ownerService.deleteBook(book.id).subscribe(() => this.ngOnInit());
  }

}
