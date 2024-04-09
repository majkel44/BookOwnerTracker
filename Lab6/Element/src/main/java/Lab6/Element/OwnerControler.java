package Lab6.Element;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
public class OwnerControler {
    private final OwnerService owner_service;
    private final CreateOwnerFunction create_owner;

    @Autowired
    public OwnerControler(OwnerService owner_service,
                          CreateOwnerFunction create_owner){
        this.owner_service = owner_service;
        this.create_owner = create_owner;
    }


    @DeleteMapping("/api/owners/{ownerID}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    public void deleteOwner(@PathVariable("ownerID")UUID id){
        owner_service.find(id)
                .ifPresentOrElse(
                        owner -> {
                            owner_service.delete(id);
                        },
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }

    @PostMapping("/api/owners")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public void createOwner(@RequestBody UUID id){
        owner_service.create(create_owner.apply(id));
    }

}
