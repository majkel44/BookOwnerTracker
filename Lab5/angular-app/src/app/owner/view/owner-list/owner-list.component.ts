import { Component, OnInit } from '@angular/core';
import { OwnerService } from "../../service/owner.service";
import { Owners } from "../../model/owners";
import { Owner } from "../../model/owner";

@Component({
  selector: 'app-owner-list',
  templateUrl: './owner-list.component.html',
  styleUrls: ['./owner-list.component.css']
})
export class OwnerListComponent {

  /**
   * @param service books service
   */
  constructor(private service: OwnerService) {
  }

  /**
   * Available books.
   */
  owners: Owners | undefined;

  ngOnInit(): void {
    this.service.getOwners().subscribe(owners => this.owners = owners);
  }

  /**
   * Deletes selected book.
   *
   * @param book book to be removed
   */
  onDelete(owner: Owner): void {
    this.service.deleteOwner(owner.id).subscribe(() => this.ngOnInit());
  }

}
