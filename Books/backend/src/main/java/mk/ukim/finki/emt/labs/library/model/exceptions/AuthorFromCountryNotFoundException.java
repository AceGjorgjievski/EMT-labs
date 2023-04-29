package mk.ukim.finki.emt.labs.library.model.exceptions;

import mk.ukim.finki.emt.labs.library.model.Country;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AuthorFromCountryNotFoundException extends RuntimeException{
    public AuthorFromCountryNotFoundException(Country country) {
        super(String.format("Author from country: %s was not found!", country.toString()));
    }
}
