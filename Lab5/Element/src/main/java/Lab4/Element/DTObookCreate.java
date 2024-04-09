package Lab5.Element;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class DTObookCreate {

    private String title;
    private int number_of_pages;
    private UUID ownerID;

}
