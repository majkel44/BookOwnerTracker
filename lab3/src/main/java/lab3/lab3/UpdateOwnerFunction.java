package lab3.lab3;

import lab3.lab3.DTOownerCreate;
import lab3.lab3.Owner;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class UpdateOwnerFunction implements BiFunction<Owner, DTOownerCreate, Owner> {
    @Override
    public Owner apply(Owner owner1, DTOownerCreate entity){
        owner1.setName(entity.getName());
        owner1.setAge(entity.getAge());
        return owner1;
    }
}
