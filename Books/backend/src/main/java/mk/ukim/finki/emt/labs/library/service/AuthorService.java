package mk.ukim.finki.emt.labs.library.service;

import mk.ukim.finki.emt.labs.library.model.Author;
import mk.ukim.finki.emt.labs.library.model.Country;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    List<Author> listAll();

    Optional<Author> findById(Long id);

    Author findByCountry(Country country);

    Author create(String name, String surname, Country country);
    Optional<Author> edit(Long id, Author author);
    Optional<Author> create(Author author);

    void deleteById(Long id);
}
