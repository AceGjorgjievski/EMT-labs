package mk.ukim.finki.emt.labs.library.model;


import lombok.Data;
import mk.ukim.finki.emt.labs.library.model.enums.Category;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Category category;

    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Author author;

    private Integer availableCopies;

    private boolean isRented;


    public Book() {
        this.isRented = false;
    }

    public Book(String name, Category category, Author author, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
        this.isRented = false;
    }
}
