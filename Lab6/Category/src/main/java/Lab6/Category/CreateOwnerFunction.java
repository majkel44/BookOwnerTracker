package Lab6.Category;

import Lab6.Category.DTOownerCreate;
import Lab6.Category.Owner;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.Function;

@Component
public class CreateOwnerFunction implements Function<DTOownerCreate, Owner> {
    @Override
    public Owner apply(DTOownerCreate entity){
        return Owner.builder()
                .uuid(UUID.randomUUID())
                .name(entity.getName())
                .age(entity.getAge())
                .build();
    }
}
