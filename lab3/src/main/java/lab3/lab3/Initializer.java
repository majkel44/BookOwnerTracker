package lab3.lab3;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Initializer implements InitializingBean {

    private final BookService bookService;
    private final OwnerService ownerService;

    @Autowired
    public Initializer (BookService bookService, OwnerService ownerService){
        this.bookService = bookService;
        this.ownerService = ownerService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Owner john = Owner.builder()
                .uuid(UUID.fromString("81e1c2a9-7f57-439b-b53d-6db88b071e4e"))
                .name("John")
                .age(30)
                .build();
        Owner jack = Owner.builder()
                .uuid(UUID.randomUUID())
                .name("Jack")
                .age(25)
                .build();
        Owner jenny = Owner.builder()
                .uuid(UUID.randomUUID())
                .name("Jenny")
                .age(28)
                .build();

        ownerService.create(john);
        ownerService.create(jack);
        ownerService.create(jenny);

        Book lastWish = Book.builder()
                .uuid(UUID.fromString("550e8400-e29b-41d4-a716-446655440000"))
                .title("lastWish")
                .number_of_pages(200)
                .owner(john)
                .build();
        Book elvishBlood = Book.builder()
                .uuid(UUID.randomUUID())
                .title("elvishBlood")
                .number_of_pages(250)
                .owner(john)
                .build();
        Book philosopherStone = Book.builder()
                .uuid(UUID.randomUUID())
                .title("philosopherStone")
                .number_of_pages(300)
                .owner(jenny)
                .build();
        Book chamberOfSecrets = Book.builder()
                .uuid(UUID.randomUUID())
                .title("chamberOfSecrets")
                .number_of_pages(240)
                .owner(jenny)
                .build();
        Book gorlansRuins = Book.builder()
                .uuid(UUID.randomUUID())
                .title("gorlansRuins")
                .number_of_pages(400)
                .owner(jack)
                .build();
        Book burnigBridge = Book.builder()
                .uuid(UUID.randomUUID())
                .title("burnigBridge")
                .number_of_pages(350)
                .owner(jack)
                .build();

        bookService.create(lastWish);
        bookService.create(elvishBlood);
        bookService.create(philosopherStone);
        bookService.create(chamberOfSecrets);
        bookService.create(gorlansRuins);
        bookService.create(burnigBridge);
    }
}
