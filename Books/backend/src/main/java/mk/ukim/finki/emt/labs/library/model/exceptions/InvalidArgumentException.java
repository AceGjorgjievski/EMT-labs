package mk.ukim.finki.emt.labs.library.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvalidArgumentException extends RuntimeException{

    public InvalidArgumentException(String username, String password) {
        super(String.format("Username %s or Password %s is invalid!", username, password));
    }
}
