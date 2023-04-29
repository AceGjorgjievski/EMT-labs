package mk.ukim.finki.emt.labs.library.model.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvalidUserCredentialsException extends RuntimeException{
    public InvalidUserCredentialsException() {
        super(String.format("Invalid username or password"));
    }
}
