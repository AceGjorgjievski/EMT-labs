package mk.ukim.finki.emt.labs.library.web.rest;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import mk.ukim.finki.emt.labs.library.model.Book;
import mk.ukim.finki.emt.labs.library.model.dto.BookDto;
import mk.ukim.finki.emt.labs.library.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/books")
public class BookRestController {

    private final BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    private List<Book> findAll() {
        return this.bookService.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        return this.bookService.findById(id)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

//    @PostMapping("/add")
//    public ResponseEntity<Book> add(@RequestBody Book book) {
//        return this.bookService.create(book)
//                .map(book1 -> ResponseEntity.ok().body(book1))
//                .orElseGet(() -> ResponseEntity.badRequest().build());
//    }

    @PostMapping("/add")
    public ResponseEntity<Book> add(@RequestBody BookDto book) {
        return this.bookService.create(book)
                .map(book1 -> ResponseEntity.ok().body(book1))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

//    @PutMapping("/{id}/edit")
//    public ResponseEntity<Book> edit(@PathVariable Long id, @RequestBody Book book) {
//        return this.bookService.edit(id, book)
//                .map(book1 -> ResponseEntity.ok().body(book1))
//                .orElseGet(() -> ResponseEntity.badRequest().build());
//    }
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final Logger logger = LoggerFactory.getLogger(BookRestController.class);
    @PutMapping("/{id}/edit")
    public ResponseEntity<Book> edit(@PathVariable Long id, @RequestBody BookDto book) {
        String requestBody;
        try {
            requestBody = objectMapper.writeValueAsString(book);
        } catch (JsonProcessingException e) {
            logger.error("Error converting book object to JSON", e);
            requestBody = "Error converting book object to JSON";
        }
        logger.info("Request body: {}", requestBody);
        return this.bookService.edit(id, book)
                .map(book1 -> ResponseEntity.ok().body(book1))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Book> delete(@PathVariable Long id) {
        this.bookService.deleteById(id);
        if(this.bookService.findById(id).isEmpty()) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}/rent")
    public ResponseEntity<Book> rent(@PathVariable Long id) {
        return this.bookService.rent(id)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
}
