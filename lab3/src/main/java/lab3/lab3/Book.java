package lab3.lab3;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
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

    public Book() {
        this.title = "title";
        this.number_of_pages = 0;
        this.owner = new Owner();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return number_of_pages == book.number_of_pages && Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, number_of_pages);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", number_of_pages=" + number_of_pages +
                ", owner=" + owner.getName() +
                '}';
    }
}