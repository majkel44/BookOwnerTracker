package Lab6.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
public class OwnerControler {
    private final OwnerService owner_service;
    private final UpdateOwnerFunction update_owner;
    private final GetOwnersFunction get_owners;
    private final GetOwnerFunction get_owner;
    private final CreateOwnerFunction create_owner;

    @Autowired
    public OwnerControler(OwnerService owner_service,
                          GetOwnersFunction get_owners,
                          GetOwnerFunction get_owner,
                          CreateOwnerFunction create_owner,
                          UpdateOwnerFunction update_owner){
        this.owner_service = owner_service;
        this.get_owner = get_owner;
        this.get_owners = get_owners;
        this.update_owner = update_owner;
        this.create_owner = create_owner;
    }

    @GetMapping("/api/owners/{ownerID}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public DTOowner getOwner(@PathVariable("ownerID") UUID id){
        return owner_service.find(id)
                .map(get_owner)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/api/owners")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public DTOowners getOwners(){
        return get_owners.apply(owner_service.findAll());
    }

    @PutMapping("/api/owners/{ownerID}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public void updateOwner(@PathVariable("ownerID") UUID id, @RequestBody DTOownerCreate owner){
        Owner owner1 = owner_service.find(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Owner not found"));
        owner_service.update(update_owner.apply(owner1, owner));
    }

    @PostMapping("/api/owners")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public void createOwner(@RequestBody DTOownerCreate owner){
        owner_service.create(create_owner.apply(owner));
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
}
