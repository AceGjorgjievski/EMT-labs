package mk.ukim.finki.emt.labs.library.service;

import mk.ukim.finki.emt.labs.library.model.Book;
import mk.ukim.finki.emt.labs.library.model.dto.BookDto;
import mk.ukim.finki.emt.labs.library.model.enums.Category;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> listAll();

    Optional<Book> findById(Long id);

    Optional<Book> findByAuthor(Long authorId);

    Book create(String name, Category category, Long authorId, Integer availableCopies);
//    Optional<Book> create(Book book);
    Optional<Book> create(BookDto book);

//    Optional<Book> edit(Long id, Book book);
    Optional<Book> edit(Long id, BookDto book);

    void deleteById(Long id);

    Optional<Book> rent(Long id);
}
