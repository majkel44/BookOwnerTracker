/*package lab3.lab3;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.function.BiFunction;
import java.util.function.Function;

public class DTOFunctions  {
    @Component
    public static class GetBooksFunction implements Function<List<Book>, DTObooks> {
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

    @Component
    public static class GetBookFunction implements Function<Book, DTObook>{
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

    @Component
    public static class UpdateBookFunction implements BiFunction<UUID, DTObookCreate, Book>{
        @Override
        public Book apply(UUID id, DTObookCreate entity) {
            return Book.builder()
                    .uuid(id)
                    .title(entity.getTitle())
                    .number_of_pages(entity.getNumber_of_pages())
                    .owner(Owner.builder()
                            .uuid(entity.getOwnerID())
                            .build())
                    .build();
        }
    }

    @Component
    public static class CreateBookFunction implements Function<DTObookCreate, Book>{
        @Override
        public Book apply(DTObookCreate entity) {
            return Book.builder()
                    .uuid(UUID.randomUUID())
                    .title(entity.getTitle())
                    .number_of_pages(entity.getNumber_of_pages())
                    .owner(Owner.builder()
                            .uuid(entity.getOwnerID())
                            .build())
                    .build();
        }
    }

    @Component
    public static class GetOwnersFunction implements Function<List<Owner>,DTOowners> {
        @Override
        public DTOowners apply(List<Owner> entities) {
            return DTOowners.builder()
                    .owners(entities.stream()
                            .map(owner -> DTOowners.Owner2.builder()
                                    .id(owner.getUuid())
                                    .name(owner.getName())
                                    .build())
                            .toList())
                    .build();
        }

    }

    @Component
    public static class GetOwnerFunction implements Function<Owner, DTOowner>{
        public DTOowner apply(Owner entity){
            return DTOowner.builder()
                    .id(entity.getUuid())
                    .name(entity.getName())
                    .age(entity.getAge())
                    .build();
        }
    }

    @Component
    public static class UpdateOwnerFunction implements BiFunction<UUID, DTOownerCreate, Owner>{
        @Override
        public Owner apply(UUID id, DTOownerCreate entity){
            return Owner.builder()
                    .uuid(id)
                    .name(entity.getName())
                    .age(entity.getAge())
                    .build();
        }
    }

    @Component
    public static class CreateOwnerFunction implements Function<DTOownerCreate, Owner>{
        @Override
        public Owner apply(DTOownerCreate entity){
            return Owner.builder()
                    .uuid(UUID.randomUUID())
                    .name(entity.getName())
                    .age(entity.getAge())
                    .build();
        }
    }
}
*/