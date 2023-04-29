package mk.ukim.finki.emt.labs.library.service.impl;

import mk.ukim.finki.emt.labs.library.model.Author;
import mk.ukim.finki.emt.labs.library.model.Country;
import mk.ukim.finki.emt.labs.library.model.exceptions.AuthorNotFoundException;
import mk.ukim.finki.emt.labs.library.model.exceptions.AuthorFromCountryNotFoundException;
import mk.ukim.finki.emt.labs.library.repository.AuthorRepository;
import mk.ukim.finki.emt.labs.library.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> listAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return this.authorRepository.findById(id);
    }

    @Override
    public Author findByCountry(Country country) {
        return this.authorRepository.findByCountryContaining(country)
                .orElseThrow(() -> new AuthorFromCountryNotFoundException(country));
    }

    @Override
    public Author create(String name, String surname, Country country) {
        Author author = new Author(name, surname, country);
        return this.authorRepository.save(author);
    }

    @Override
    public Optional<Author> edit(Long id, Author author) {
        Author author1 = this.findById(id)
                .orElseThrow(() -> new AuthorNotFoundException(id));


        return Optional.of(this.authorRepository.save(author1));
    }

    @Override
    public Optional<Author> create(Author author) {
        Author author1 = new Author(author.getName(), author.getSurname(), author.getCountry());

        author1.setName(author.getName());
        author1.setSurname(author.getSurname());
        author1.setCountry(author.getCountry());

        return Optional.of(this.authorRepository.save(author1));
    }

    @Override
    public void deleteById(Long id) {
        this.authorRepository.deleteById(id);
    }
}
