package Lab6.Category;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
@Entity
@Table(name= "Owners" )
public class Owner implements Serializable {
    @Id
    UUID uuid;
    @Column
    String name;
    int age;


}