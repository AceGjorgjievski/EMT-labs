package mk.ukim.finki.emt.labs.library.service.impl;

import mk.ukim.finki.emt.labs.library.model.Author;
import mk.ukim.finki.emt.labs.library.model.Book;
import mk.ukim.finki.emt.labs.library.model.dto.BookDto;
import mk.ukim.finki.emt.labs.library.model.enums.Category;
import mk.ukim.finki.emt.labs.library.model.events.BookCreatedEvent;
import mk.ukim.finki.emt.labs.library.model.exceptions.AuthorNotFoundException;
import mk.ukim.finki.emt.labs.library.model.exceptions.BookNotFoundException;
import mk.ukim.finki.emt.labs.library.repository.AuthorRepository;
import mk.ukim.finki.emt.labs.library.repository.BookRepository;
import mk.ukim.finki.emt.labs.library.service.BookService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    public BookServiceImpl(BookRepository bookRepository,
                           AuthorRepository authorRepository,
                           ApplicationEventPublisher applicationEventPublisher) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public List<Book> listAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public Optional<Book> findByAuthor(Long authorId) {
        Author author = this.authorRepository.findById(authorId)
                .orElseThrow(() -> new AuthorNotFoundException(authorId));


        return this.bookRepository.findByAuthorContaining(author);
    }

    @Override
    public Book create(String name, Category category, Long authorId, Integer availableCopies) {
        Author author = this.authorRepository.findById(authorId)
                .orElseThrow(() -> new AuthorNotFoundException(authorId));

        Book book = new Book(name, category, author, availableCopies);

        return this.bookRepository.save(book);
    }

    @Override
    @Transactional
    public Optional<Book> create(BookDto bookDto) {
        Author author = this.authorRepository.findById(bookDto.getAuthor())
                .orElseThrow(() -> new AuthorNotFoundException(bookDto.getAuthor()));

        this.bookRepository.deleteByName(bookDto.getName());
        Book book = new Book(bookDto.getName(),bookDto.getCategory(),author,bookDto.getAvailableCopies());
        this.bookRepository.save(book);


        this.applicationEventPublisher.publishEvent(new BookCreatedEvent(book));
        return Optional.of(book);

    }

    @Override
    public Optional<Book> edit(Long id, BookDto bookDto) {
        Book book = this.bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));

        Author author = this.authorRepository.findById(bookDto.getAuthor())
                .orElseThrow(() -> new AuthorNotFoundException(bookDto.getAuthor()));

        book.setName(bookDto.getName());
        book.setCategory(bookDto.getCategory());
        book.setAuthor(author);
        book.setAvailableCopies(bookDto.getAvailableCopies());

        this.bookRepository.save(book);
        return Optional.of(book);
    }

//    @Override
//    public Optional<Book> create(Book book) {
//        Book book1 = new Book(book.getName(), book.getCategory(), book.getAuthor(), book.getAvailableCopies());
//        return Optional.of(this.bookRepository.save(book1));
//    }

//    @Override
//    public Optional<Book> edit(Long id, Book book) {
//        Book book1 = this.findById(id)
//                .orElseThrow(() -> new BookNotFoundException(id));
//
//        book1.setAuthor(book.getAuthor());
//        book1.setCategory(book.getCategory());
//        book1.setAvailableCopies(book.getAvailableCopies());
//        book1.setName(book.getName());
//
//        return Optional.of(this.bookRepository.save(book1));
//    }

    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }

    @Override
    public Optional<Book> rent(Long id) {
        Book book = this.findById(id)
                .orElseThrow(() ->  new BookNotFoundException(id));

        boolean isRent = book.isRented();
        if(!isRent && book.getAvailableCopies() > 0) {
            book.setAvailableCopies(book.getAvailableCopies()-1);
        }

        if(book.getAvailableCopies() == 0) {
            book.setRented(true);
        }

        return Optional.of(this.bookRepository.save(book));
    }
}
