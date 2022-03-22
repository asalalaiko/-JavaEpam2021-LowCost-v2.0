package by.asalalaiko.controller.user;

import by.asalalaiko.domain.Flight;
import by.asalalaiko.domain.FlightToOrder;
import by.asalalaiko.domain.FlightToOrderList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class OrderUserController {

    @PostMapping("/order")
    String createOrder(@ModelAttribute FlightToOrderList flightToOrderList, Model model) {

        System.out.println(flightToOrderList.getFlightToOrders());
            model.addAttribute("flightToOrderList", flightToOrderList);
        return "redirect:/order";
    }


    @GetMapping("/order")
    String getOrders(Model model){
        model.addAttribute("flightToOrderList", model);
        return "/order";}
}
