package Lab6.Element;

import Lab6.Element.Book;
import Lab6.Element.DTObook;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class GetBookFunction implements Function<Book, DTObook> {
    public DTObook apply(Book entity){
        return DTObook.builder()
                .id(entity.getUuid())
                .title(entity.getTitle())
                .number_of_pages(entity.getNumber_of_pages())
                .owner(DTObook.Owner2.builder()
                        .id(entity.getOwner().getUuid())
                        .build())
                .build();
    }
}
