package by.asalalaiko.controller.user;

import by.asalalaiko.domain.*;
import by.asalalaiko.repo.UserRepo;
import by.asalalaiko.service.OrderService;
import by.asalalaiko.service.TicketService;
import by.asalalaiko.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class OrderUserController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;
    @Autowired
    private TicketService ticketService;

    @PostMapping("/user/order")
    String createOrder(@ModelAttribute FlightToOrderList flightToOrderList, Authentication authentication) {

        User user = userService.getUserByLogin(authentication.getName());

        Order order = orderService.createOrder(flightToOrderList, user);

        return "redirect:/user/order?id="+order.getId();
    }

    @GetMapping("/user/order")
    String getOrder(@RequestParam(value="id") Long id, Model model){

        Order order = orderService.getOrderById(id);

        model.addAttribute("order", order);
        model.addAttribute("tickets", ticketService.getTicketsByOrder(order));
        return "/user/order";}


    @GetMapping("/user/order/{orderId}/deleteticket")
    String deleteTicketToOrder(@PathVariable("orderId") Long orderId, @RequestParam(value="id") Long id){

        Order order = orderService.getOrderById(orderId);
        Ticket ticket = ticketService.getTicketById(id);

        if (ticket.getOrder().equals(order) && (order.getStatus() != OrderStatus.PAID)) {
            ticket.setOrder(null);
            ticket.setStatus(TicketStatus.FREE);
            ticketService.updateTicket(ticket);
        }

        return "redirect:/user/order?id="+order.getId();
    }



    @GetMapping("/user/orders")
    String getOrders(Model model, Authentication authentication){

        User user = userService.getUserByLogin(authentication.getName());

        model.addAttribute("orders", orderService.getOrdersByUser(user));
        return "/user/orders";}
}
