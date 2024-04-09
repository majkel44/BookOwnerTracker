package lab3.lab3;

import lab3.lab3.DTOowners;
import lab3.lab3.Owner;
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
