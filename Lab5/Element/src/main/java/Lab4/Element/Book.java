package Lab5.Element;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
@Entity
@Table(name= "Books")
public class Book implements Serializable {
    @Id
    UUID uuid;

    private String title;

    private int number_of_pages;
    @ManyToOne
    @JoinColumn(name = "owner")
    private Owner owner;


}