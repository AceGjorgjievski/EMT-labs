package mk.ukim.finki.emt.labs.library.model.dto;

import lombok.Data;
import mk.ukim.finki.emt.labs.library.model.enums.Category;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class BookDto {

    private String name;

    @Enumerated(EnumType.STRING)
    private Category category;

    private Long author;

    private Integer availableCopies;

    public BookDto(String name, Category category, Long author, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }
}

