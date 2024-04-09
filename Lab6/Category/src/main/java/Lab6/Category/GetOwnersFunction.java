package Lab6.Category;

import Lab6.Category.DTOowners;
import Lab6.Category.Owner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class GetOwnersFunction implements Function<List<Owner>, DTOowners> {
    @Override
    public DTOowners apply(List<Owner> entities) {
        return DTOowners.builder()
                .owners(entities.stream()
                        .map(owner -> DTOowners.Owner2.builder()
                                .id(owner.getUuid())
                                .name(owner.getName())
                                .build())
                        .toList())
                .build();
    }

}
