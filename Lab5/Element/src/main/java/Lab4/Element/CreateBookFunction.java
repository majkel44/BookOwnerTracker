package Lab5.Element;

import Lab5.Element.Book;
import Lab5.Element.DTObookCreate;
import Lab5.Element.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;
import java.util.function.Function;

@Component
public class CreateBookFunction implements Function<DTObookCreate, Book> {
    private final OwnerService owner_service;
    @Autowired
    public CreateBookFunction(OwnerService owner_service){
        this.owner_service = owner_service;
    }
    @Override
    public Book apply(DTObookCreate entity) {
        Owner owner = owner_service.find(entity.getOwnerID())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Owner not found"));
        return Book.builder()
                .uuid(UUID.randomUUID())
                .title(entity.getTitle())
                .number_of_pages(entity.getNumber_of_pages())
                .owner(owner)
                .build();
    }
}
