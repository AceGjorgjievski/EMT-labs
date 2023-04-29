package mk.ukim.finki.emt.labs.library.web.controller;


import mk.ukim.finki.emt.labs.library.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"/","/books"})
public class BooksController {

    private final BookService bookService;

    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping
    public String showAllBooks(Model model) {
        return "master-template";
    }

}
