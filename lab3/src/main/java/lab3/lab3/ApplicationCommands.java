/*package lab3.lab3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;
import java.util.UUID;

@Component
public class ApplicationCommands implements CommandLineRunner {

    public final BookService bookService;
    public final OwnerService ownerService;

    @Autowired
    public ApplicationCommands(BookService bookService, OwnerService ownerService){
        this.bookService = bookService;
        this.ownerService = ownerService;
    }

    @Override
    public void run(String... args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        String command;
        main_loop:
        while (true) {
            System.out.println("Choose command from:");
            System.out.println("get_owners");
            System.out.println("get_books");
            System.out.println("add_book");
            System.out.println("delete_book");
            System.out.println("quit");

            command = scanner.next();
            switch (command) {
                case "get_owners" -> {
                    Iterable<Owner> entities = ownerService.findAll();
                    for (Owner entity : entities)
                    System.out.println(entity);
                }
                case "get_books" -> {
                    Iterable<Book> entities = bookService.findAll();
                    for (Book entity : entities)
                        System.out.println(entity);
                }
                // ed6cfb2a-cad7-47dd-9b56-9d1e3c7a4197 UUID example
                case "add_book" -> {
                    System.out.println("Provide owner UUID");
                    UUID id = UUID.fromString(scanner.next());
                    Owner owner = ownerService.find(id).orElse(new Owner());
                    System.out.println("Provide book UUID, title and number of pages");
                    Book book = Book.builder()
                            .uuid(UUID.fromString(scanner.next()))
                            .title(scanner.next())
                            .number_of_pages(scanner.nextInt())
                            .owner(owner)
                            .build();
                    try{
                        bookService.create(book);
                    } catch (Exception e){
                        System.out.println("Wrong input:");
                    }
                }
                case "delete_book" -> {
                    System.out.println("Provide book UUID");
                    try{
                        UUID id = UUID.fromString(scanner.next());
                        bookService.delete(id);
                    } catch (Exception e){
                        System.out.println("Wrong input:");
                    }
                }
                case "quit" -> {
                    break main_loop;
                }

            }
        }
    }
}
*/