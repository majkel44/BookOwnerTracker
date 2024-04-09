import { Owner } from "../../owner/model/owner";

/**
 * Represents single book in list.
 */
export interface BookDetails {

  /**
   * Unique id identifying book.
   */
  id: string;

  /**
   * Title of the book.
   */
  title: string;

  number_of_pages: number;

  /**
   * Book's owner.
   */
  owner: Owner;

}
