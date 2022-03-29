package by.asalalaiko.exception;

import by.asalalaiko.controller.RegistrationController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyExceptionHandler.class);

    @ExceptionHandler(value = UserNotFoundException.class)
    public String userNotFoundException1(UserNotFoundException exception, Model model) {
        model.addAttribute("message", "User not found!");
        model.addAttribute("title", "Error page");
        LOGGER.error("User not found error", exception.getMessage());
        return "error";
    }



    @ExceptionHandler(value = NullPointerException.class)
    public String nullPointerHandler(Model model) {
        model.addAttribute("title", "Error page");
        model.addAttribute("message", "NullPointerException");
        LOGGER.error("NullPointerException");
        return "error";
    }

    @ExceptionHandler(value = Exception.class)
    public String AnyOtherHandler() {
        LOGGER.error("Exception");
        return "error";
    }
}
