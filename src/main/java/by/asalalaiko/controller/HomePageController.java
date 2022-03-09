package by.asalalaiko.controller;

import by.asalalaiko.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String Home (Model model){
        model.addAttribute("title", "Main page");
        model.addAttribute("users", userService.findAll());
        return "index";
    }


    @GetMapping("/index")
    public String index (Model model){
        model.addAttribute("title", "Main page");
        model.addAttribute("users", userService.findAll());
        return "index";
    }
}
