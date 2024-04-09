import { Component, OnInit } from '@angular/core';
import { OwnerService } from '../../service/owner.service';
import { ActivatedRoute, Router } from '@angular/router';
import { OwnerForm } from '../../model/owner-form';
import {Books} from "../../../book/model/books";
import {BookService} from "../../../book/service/book.service";

@Component({
  selector: 'app-owner-edit',
  templateUrl: './owner-edit.component.html',
  styleUrls: ['./owner-edit.component.css']
})
export class OwnerEditComponent implements OnInit {

  /**
   * Book's id.
   */
  uuid: string | undefined;

  /**
   * Single owner.
   */
  owner: OwnerForm | undefined;

  /**
   * Single owner.
   */
  original: OwnerForm | undefined;

  /**
   * Available books.
   */
  books: Books | undefined;

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
      this.ownerService.getOwner(params['uuid'])
        .subscribe(owner => {
          this.uuid = owner.id;
          this.owner = {
            name: owner.name,
            age: owner.age,
          };
          this.original = {...this.owner};
        });
    });
  }

  /**
   * Updates owner.
   */
  onSubmit(): void {
    this.ownerService.putOwner(this.uuid!, this.owner!)
      .subscribe(() => this.router.navigate(['/owners']));
  }

}
