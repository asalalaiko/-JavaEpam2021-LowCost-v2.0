package by.asalalaiko.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CartController {

    @GetMapping("/cart/add")
    public String add (Model model){
//        model.addAttribute("title", "Main page");
//        model.addAttribute("flights", flightService.getFlights());
        return "redirect:/";
    }
}
