package mk.ukim.finki.emt.labs.library.model.exceptions;

import mk.ukim.finki.emt.labs.library.model.Author;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BookWithAuthorNotFoundException extends RuntimeException{
    public BookWithAuthorNotFoundException(Author author) {
        super(String.format("Book with author: %s was not found!", author.getName()));
    }
}
