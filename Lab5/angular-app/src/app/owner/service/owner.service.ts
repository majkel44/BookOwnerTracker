import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Owners } from "../model/owners";
import {Owner} from "../model/owner";
import {OwnerForm} from "../model/owner-form";
import {OwnerDetails} from "../model/owner-details";
import {Books} from "../../book/model/books";

@Injectable({
  providedIn: 'root'
})
export class OwnerService {

  /**
   * @param http HTTP client
   */
  constructor(private http: HttpClient) {

  }


  getOwners(): Observable<Owners> {
    return this.http.get<Owners>('/api/owners');
  }

  deleteOwner(uuid: string) {
    return this.http.delete('/api/owners/' + uuid);
  }

  getOwner(uuid: string) {
    return this.http.get<OwnerDetails>('/api/owners/' + uuid);
  }

  putOwner(uuid: string, ownerForm: OwnerForm) {
    return this.http.put('/api/owners/' + uuid, ownerForm);
  }

  getOwnerBooks(uuid: string) {
    return this.http.get<Books>('/api/owners/' + uuid + '/books');
  }

  deleteBook(uuid: string): Observable<any> {
    return this.http.delete('/api/books/' + uuid);
  }
}
