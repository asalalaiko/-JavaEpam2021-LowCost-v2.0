package by.asalalaiko.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;


public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException() {
    }

    public UserNotFoundException(String code) {
        super("Could not find user with activation code " + code);
    }

    public UserNotFoundException(Long id) {
        super("Could not find user with ID " + id);
    }


}
