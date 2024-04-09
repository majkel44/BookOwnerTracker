package Lab6.Category;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OwnerService {

    private final OwnerRepository repository;
    private final OwnerEvent event;

    @Autowired
    public OwnerService (OwnerRepository repository, OwnerEvent event){
        this.event = event;
        this.repository = repository;
    }

    public Optional<Owner> find(UUID id){
        return repository.findById(id);
    }

    public void create(Owner owner){
        repository.save(owner);
        //event.create(owner.getUuid());
    }

    public void update(Owner owner){
        repository.save(owner);
    }

    public void delete (UUID id){
        repository.findById(id).ifPresent(repository::delete);
        event.delete(id);
    }


    List<Owner> findAll(){
        return repository.findAll();
    }

}
