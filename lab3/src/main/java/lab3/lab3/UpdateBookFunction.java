package lab3.lab3;

import lab3.lab3.Book;
import lab3.lab3.DTObookCreate;
import lab3.lab3.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class UpdateBookFunction implements BiFunction<Book , DTObookCreate, Book> {
    private final OwnerService owner_service;
    @Autowired
    public UpdateBookFunction(OwnerService owner_service){
    this.owner_service = owner_service;
    }

    @Override
    public Book apply(Book book1, DTObookCreate entity) {
        book1.setTitle(entity.getTitle());
        book1.setNumber_of_pages(entity.getNumber_of_pages());
        Owner owner = owner_service.find(entity.getOwnerID())
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Owner not found"));
        book1.setOwner(owner);
        return book1;
    }
}
