package by.asalalaiko.controller;

import by.asalalaiko.domain.Flight;
import by.asalalaiko.domain.FlightToOrder;
import by.asalalaiko.domain.FlightToOrderList;
import by.asalalaiko.service.FlightService;
import by.asalalaiko.service.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@Controller
public class CartController {

    @Autowired
    private FlightService flightService;

    @GetMapping("/cart/add")
    protected void addToCart (HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String referer = req.getHeader("Referer");
        HashSet<Long> cartFlights =  new HashSet <Long>();
        HashSet<Long> session  =(HashSet<Long>) req.getSession().getAttribute("cartFlights");
        if( session != null) {cartFlights.addAll(session);}

        Long flightId = Long.valueOf(req.getParameter("id"));

        try {

            cartFlights.add(flightId);
            req.getSession().setAttribute("cartFlights", cartFlights);

            resp.sendRedirect(referer);
        } catch (Exception e) {
            throw new IOException(e);
        }
    }


    @GetMapping("/cart")
    public String getFlightToCart(Model model, HttpServletRequest req, HttpServletResponse resp) throws IOException{
        try {

            FlightToOrderList flightsToOrderList = new FlightToOrderList();
            List<FlightToOrder> flightToOrders = new ArrayList<>();
            HashSet<Long> session  =(HashSet<Long>) req.getSession().getAttribute("cartFlights");
            if( session != null) {
                session.stream().forEach((k) -> {
                    flightToOrders.add(new FlightToOrder(flightService.getFlightById(k), 1));
                });
            }

            flightsToOrderList.setFlightToOrders((ArrayList<FlightToOrder>) flightToOrders);
            model.addAttribute("flightsToOrderList", flightsToOrderList);
            return "/cart";
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    @GetMapping("/cart/delete")
    protected void dellToCart (HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Long id = Long.valueOf(req.getParameter("id"));

        try {
            HashSet<Long> flights  =(HashSet<Long>) req.getSession().getAttribute("cartFlights");
            if( flights != null) {
                flights.removeIf(k -> k.equals(id));
                req.getSession().setAttribute("cartFlights", flights);
            }
            req.getRequestDispatcher("/cart").forward(req, resp);
        } catch (Exception e) {
            throw new IOException(e);
        }

    }

}
