package Lab5.Element;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
public class BookControler{
    private final BookService book_service;
    private final GetBooksFunction get_books;
    private final GetBookFunction get_book;
    private final UpdateBookFunction update_book;
    private final CreateBookFunction create_book;



    @Autowired
    public BookControler (BookService service,
                          GetBooksFunction get_books,
                          GetBookFunction get_book,
                          UpdateBookFunction update_book,
                          CreateBookFunction create_book){
        this.book_service = service;
        this.get_books = get_books;
        this.get_book = get_book;
        this.update_book = update_book;
        this.create_book = create_book;
    }

    @GetMapping("/api/books/{bookID}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public DTObook getBook(@PathVariable("bookID") UUID id){
        return book_service.find(id)
                .map(get_book)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/api/owners/{ownerID}/books")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public DTObooks getOwnerBooks(@PathVariable("ownerID") UUID id){
        return get_books.apply(book_service.findAllByOwner(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    @GetMapping("/api/books")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public DTObooks getBooks(){
        return get_books.apply(book_service.findAll());
    }

    /*HERE UPDATE*/
    @PutMapping("/api/books/{bookID}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public void updateBook(@PathVariable("bookID") UUID id, @RequestBody  DTObookCreate book){
        Book book1 = book_service.find(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found"));
        book_service.update(update_book.apply(book1, book));
    }

    @PostMapping("/api/books")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public void createBook(@RequestBody DTObookCreate book){
        book_service.create(create_book.apply(book));
    }


    @DeleteMapping("/api/books/{bookID}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    public void deleteBook(@PathVariable("bookID") UUID id){
        book_service.find(id)
                .ifPresentOrElse(
                        book -> book_service.delete(id),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }

}
