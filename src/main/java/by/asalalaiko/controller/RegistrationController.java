package by.asalalaiko.controller;

import by.asalalaiko.domain.CaptchaResponseDto;
import by.asalalaiko.domain.User;
import by.asalalaiko.exception.UserNotFoundException;
import by.asalalaiko.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {

    private final static String CAPTCHA_URL = "https://www.google.com/recaptcha/api/siteverify?secret=%s&response=%s";
    private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationController.class);



    @Autowired
    private UserService userService;
    @Value("${recaptcha.secret}")
    private String secret;
    @Autowired
    private RestTemplate restTemplate;



    @GetMapping("/activate")
    String activationUser(@RequestParam(name = "code", required = true) String code) {

            User user = userService.activateUser(code);
            if (user==null)
                throw new  UserNotFoundException(code);

            LOGGER.info("Activation user", user.getLogin());

   return "redirect:/login";
    }



    @GetMapping("/register")
    String getForm(Model model) {
        model.addAttribute("title", "Registration page");
        model.addAttribute("user", new User());
        return "registration";
    }


    @PostMapping("/register")
    String registerPage(@RequestParam("g-recaptcha-response") String captchaResponse,
                        @Valid User user,
                        BindingResult bindingResult,
                        Model model) throws MessagingException {
        String url = String.format(CAPTCHA_URL, secret, captchaResponse);
        CaptchaResponseDto response = restTemplate.postForObject(
                url, Collections.emptyList(), CaptchaResponseDto.class);


        if (!response.isSuccess()) {
            model.addAttribute("captchaError", "Fill captcha");
        }

        if (bindingResult.hasErrors() || !response.isSuccess()) {
            Map<String, String> errors = ControllerUtils.getErrors(bindingResult);

            model.mergeAttributes(errors);

            return "registration";
        }

        if (!userService.addUser(user)) {
            model.addAttribute("usernameError", "User exists!");
            return "registration";
        }
        return "redirect:/login";
    }

}

