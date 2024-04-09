package lab3.lab3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookService {

    private final BookRepository bookRepository;

    private final OwnerRepository ownerRepository;

    @Autowired
    public BookService(BookRepository bookRepository, OwnerRepository ownerRepository){
        this.bookRepository = bookRepository;
        this.ownerRepository = ownerRepository;
    }
    public Optional<Book> find(UUID id){
        return bookRepository.findById(id);
    }

    List<Book> findAll(){
        return bookRepository.findAll();
    }

    List<Book> findAll(Owner owner){
        return bookRepository.findAllByOwner(owner);
    }

    public void create (Book book){
        bookRepository.save(book);
    }

    public void update (Book book){
        bookRepository.save(book);
    }

    public void delete (UUID id){
        bookRepository.findById(id).ifPresent(bookRepository::delete);
    }

    Optional<List<Book>> findAllByOwner(UUID ownerID){
        return ownerRepository.findById(ownerID)
                .map(bookRepository::findAllByOwner);
    }
}
