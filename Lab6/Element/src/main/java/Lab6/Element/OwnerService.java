package Lab6.Element;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OwnerService {

    private final OwnerRepository repository;

    @Autowired
    public OwnerService (OwnerRepository repository){
        this.repository = repository;
    }

    public Optional<Owner> find(UUID id){
        return repository.findById(id);
    }

    public void create(Owner owner){
        repository.save(owner);
    }

    public void delete (UUID id){
        repository.findById(id).ifPresent(repository::delete);
    }


}
