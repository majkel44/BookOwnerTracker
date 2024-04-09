package lab3.lab3;

import lab3.lab3.Book;
import lab3.lab3.DTObook;
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
                        .name(entity.getOwner().getName())
                        .build())
                .build();
    }
}
