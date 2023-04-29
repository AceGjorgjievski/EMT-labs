package mk.ukim.finki.emt.labs.library.repository;

import mk.ukim.finki.emt.labs.library.model.Author;
import mk.ukim.finki.emt.labs.library.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findByAuthorContaining(Author author);
    void deleteById(Long id);
    void deleteByName(String name);
    Page<Book> findAll(Pageable pageable);

}
