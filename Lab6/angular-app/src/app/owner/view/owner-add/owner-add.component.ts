import { Component, OnInit } from '@angular/core';
import { OwnerService } from '../../service/owner.service';
import { ActivatedRoute, Router } from '@angular/router';
import { OwnerForm } from '../../model/owner-form';
import {Books} from "../../../book/model/books";
import {BookService} from "../../../book/service/book.service";

@Component({
  selector: 'app-owner-add',
  templateUrl: './owner-add.component.html',
  styleUrls: ['./owner-add.component.css']
})
export class OwnerAddComponent implements OnInit {

  uuid: string | undefined;

  owner: OwnerForm | undefined;

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
    this.owner = {
      name: '',
      age: 0
    }
  }

  /**
   * Updates book.
   */
  onSubmit(): void {
    this.ownerService.putOwner(this.uuid!, this.owner!)
      .subscribe(() => this.router.navigate(['/owners']));
  }

}
