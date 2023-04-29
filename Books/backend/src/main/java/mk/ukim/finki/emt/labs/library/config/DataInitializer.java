package mk.ukim.finki.emt.labs.library.config;

import mk.ukim.finki.emt.labs.library.model.Author;
import mk.ukim.finki.emt.labs.library.model.Country;
import mk.ukim.finki.emt.labs.library.model.enums.Category;
import mk.ukim.finki.emt.labs.library.model.enums.Role;
import mk.ukim.finki.emt.labs.library.service.AuthorService;
import mk.ukim.finki.emt.labs.library.service.BookService;
import mk.ukim.finki.emt.labs.library.service.CountryService;
import mk.ukim.finki.emt.labs.library.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
public class DataInitializer {

    private final AuthorService authorService;
    private final CountryService countryService;
    private final BookService bookService;
    private final UserService userService;


    public DataInitializer(AuthorService authorService,
                           CountryService countryService,
                           BookService bookService,
                           UserService userService) {
        this.authorService = authorService;
        this.countryService = countryService;
        this.bookService = bookService;
        this.userService = userService;
    }

    private String randomizeCountry(int i) {
        if (i == 0) return "Europe";
        else if (i == 1) return "Asia";
        else if (i == 2) return "North America";
        else if (i == 3) return "South America";
        else if (i == 4) return "Africa";
        else return "Australia";
    }

    private Role randomizeRole(int i) {
        if(i%2 == 0) return Role.LIBRARIAN;
        else return Role.USER;
    }

    @PostConstruct
    public void init() {
        Random random = new Random();

        for(int i=1; i<6; i++) {
            this.userService.create(
                    "User: " + i,
                    "User: "+i,
                    "user."+i+"@emt.finki.ukim.mk",
                    "user"+i,
                    "user"+i,
                    this.randomizeRole(i)
            );
        }

        for (int i = 1; i < 6; i++) {
            this.countryService.save("Country: " + i,
                    this.randomizeCountry(random.nextInt(6)));
        }

        List<Country> countryList = this.countryService.listAll();

        for (int i = 1; i < 6; i++) {
            this.authorService.create("Author Name: " + i,
                    "Author Surname: " + i,
                    countryList.get(random.nextInt(countryList.size())));
        }

        List<Author> authors = this.authorService.listAll();

        List<Category> categories = Arrays.stream(Category.values()).toList();
        for (int i = 1; i < 10; i++) {
            this.bookService.create("Book: " + i,
                    categories.get(random.nextInt(categories.size())),
                    authors.get(random.nextInt(authors.size())).getId(),
                    random.nextInt(10));
        }
    }
}
