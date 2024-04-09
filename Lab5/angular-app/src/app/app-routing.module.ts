import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BookListComponent } from "./book/view/book-list/book-list.component";
import { BookViewComponent } from "./book/view/book-view/book-view.component";
import { BookEditComponent } from "./book/view/book-edit/book-edit.component";
import {OwnerListComponent} from "./owner/view/owner-list/owner-list.component";
import {OwnerViewComponent} from "./owner/view/owner-view/owner-view.component";
import {OwnerEditComponent} from "./owner/view/owner-edit/owner-edit.component";

/**
 * All available routes.
 */
const routes: Routes = [
  {
    component: BookListComponent,
    path: "books"
  },
  {
    component: BookViewComponent,
    path: "books/:uuid"
  }
  ,
  {
    component: BookEditComponent,
    path: "books/:uuid/edit"
  }
  ,
  {
    component: OwnerListComponent,
    path: "owners"
  },
  {
    component: OwnerViewComponent,
    path: "owners/:uuid"
  }
  ,
  {
    component: OwnerEditComponent,
    path: "owners/:uuid/edit"
  }
];

/**
 * Global routing module.
 */
@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule {

}
