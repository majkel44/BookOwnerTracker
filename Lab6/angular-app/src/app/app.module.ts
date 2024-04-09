import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FooterComponent } from './component/footer/footer.component';
import { HeaderComponent } from './component/header/header.component';
import { NavComponent } from './component/nav/nav.component';
import { MainComponent } from './component/main/main.component';
import { HttpClientModule } from "@angular/common/http";
import { BookListComponent } from './book/view/book-list/book-list.component';
import { BookService } from './book/service/book.service';
import { BookViewComponent } from './book/view/book-view/book-view.component';
import { BookEditComponent } from './book/view/book-edit/book-edit.component';
import { FormsModule } from "@angular/forms";
import { OwnerListComponent } from './owner/view/owner-list/owner-list.component';
import { OwnerEditComponent } from './owner/view/owner-edit/owner-edit.component';
import { OwnerViewComponent } from './owner/view/owner-view/owner-view.component';
import {OwnerService} from "./owner/service/owner.service";
import { OwnerAddComponent } from './owner/view/owner-add/owner-add.component';
import { BookAddComponent } from './book/view/book-add/book-add.component';

/**
 * Application main module.
 */
@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    HeaderComponent,
    NavComponent,
    MainComponent,
    BookListComponent,
    BookViewComponent,
    BookEditComponent,
    OwnerListComponent,
    OwnerEditComponent,
    OwnerViewComponent,
    OwnerAddComponent,
    OwnerAddComponent,
    BookAddComponent,
    BookAddComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    BookService,
    OwnerService,
  ],
  bootstrap: [
    AppComponent
  ]
})
export class AppModule {

}
