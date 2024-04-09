package lab3.lab3;

import lab3.lab3.DTOowner;
import lab3.lab3.Owner;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class GetOwnerFunction implements Function<Owner, DTOowner> {
    public DTOowner apply(Owner entity){
        return DTOowner.builder()
                .id(entity.getUuid())
                .name(entity.getName())
                .age(entity.getAge())
                .build();
    }
}
