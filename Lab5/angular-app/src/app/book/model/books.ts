import { Book } from "./book";

/**
 * GET books response. Contains list of available books. Can be used to list particular user's books as
 * well as all books in the game.
 */
export interface Books {

  /**
   * Name of the selected books.
   */
  books:Book[];

}
