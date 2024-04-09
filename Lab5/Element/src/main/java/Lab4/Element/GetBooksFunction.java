package Lab5.Element;

import Lab5.Element.Book;
import Lab5.Element.DTObooks;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class GetBooksFunction implements Function<List<Book>, DTObooks> {
    @Override
    public DTObooks apply(List<Book> entities) {
        return DTObooks.builder()
                .books(entities.stream()
                        .map(book -> DTObooks.Book2.builder()
                                .id(book.getUuid())
                                .title(book.getTitle())
                                .number_of_pages(book.getNumber_of_pages())
                                .build())
                        .toList())
                .build();
    }

}
