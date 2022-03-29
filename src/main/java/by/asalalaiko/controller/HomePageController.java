package by.asalalaiko.controller;

import by.asalalaiko.service.FlightService;
import by.asalalaiko.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    @Autowired
    private FlightService flightService;
    @GetMapping("/")
    public String Home (Model model){
        model.addAttribute("title", "Main page");
        model.addAttribute("flights", flightService.getFlights());
        return "index";
    }

}
