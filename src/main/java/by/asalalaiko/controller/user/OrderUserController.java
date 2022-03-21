package by.asalalaiko.controller.user;

import by.asalalaiko.domain.Flight;
import by.asalalaiko.domain.FlightToOrder;
import by.asalalaiko.domain.FlightToOrderList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class OrderUserController {

    @PostMapping("/order")
    String createOrder(FlightToOrderList flightToOrderList) {

        return "redirect:/order";
    }

}
