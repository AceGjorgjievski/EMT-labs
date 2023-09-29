package mk.ukim.finki.emt.labs.library.web.rest;


import mk.ukim.finki.emt.labs.library.model.Author;
import mk.ukim.finki.emt.labs.library.service.AuthorService;
import mk.ukim.finki.emt.labs.library.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/authors")
public class AuthorRestController {

    private final AuthorService authorService;
    private final BookService bookService;

    public AuthorRestController(AuthorService authorService, BookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @GetMapping
    private List<Author> findAll() {
        return this.authorService.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> findById(@PathVariable Long id) {
        return this.authorService.findById(id)
                .map(author -> ResponseEntity.ok().body(author))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Author> add(@RequestBody Author author) {
        return this.authorService.create(author)
                .map(author1 -> ResponseEntity.ok().body(author1))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PostMapping("/{id}/edit")
    public ResponseEntity<Author> edit(@PathVariable Long id, Author author) {
        return this.authorService.edit(id, author)
                .map(author1 -> ResponseEntity.ok().body(author1))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Author> delete(@PathVariable Long id) {
        this.authorService.deleteById(id);
        if (this.authorService.findById(id).isEmpty()) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
