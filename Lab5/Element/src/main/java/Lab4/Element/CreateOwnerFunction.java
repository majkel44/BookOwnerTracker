package Lab5.Element;

import Lab5.Element.DTOownerCreate;
import Lab5.Element.Owner;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.Function;

@Component
public class CreateOwnerFunction implements Function<UUID, Owner> {
    @Override
    public Owner apply(UUID id){
        return Owner.builder()
                .uuid(id)
                .build();
    }
}
