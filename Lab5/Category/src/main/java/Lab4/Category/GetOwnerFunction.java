package Lab5.Category;

import Lab5.Category.DTOowner;
import Lab5.Category.Owner;
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
