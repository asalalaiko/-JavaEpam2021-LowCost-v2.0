package by.asalalaiko.controller.admin;



import by.asalalaiko.domain.Flight;
import by.asalalaiko.domain.Plane;
import by.asalalaiko.domain.Ticket;
import by.asalalaiko.domain.TicketStatus;
import by.asalalaiko.service.FlightService;
import by.asalalaiko.service.PlaneService;
import by.asalalaiko.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Controller
public class TicketAdminController {

    @Autowired
    private TicketService ticketService;
    @Autowired
    private FlightService flightService;

    @GetMapping("/admin/ticket")
    public String getAllTickets(@RequestParam(required = false) Long id,
                                @RequestParam(name = "page", required = true, defaultValue = "1") int page,
                                @RequestParam(name = "limit", required = true, defaultValue = "20") int limit,
                                Model model){
        try {
        Pageable paging = PageRequest.of(page-1, limit);


        if (id != null) {
            Flight flight = flightService.getFlightById(id);
            Page<Ticket> ticketsPage = ticketService.getTicketsByFlight(flight, paging);
            int totalPages = ticketsPage.getTotalPages();
            if (totalPages > 0) {
                List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                        .boxed()
                        .collect(Collectors.toList());
                model.addAttribute("pageNumbers", pageNumbers);
            }

            model.addAttribute("title", "Admin - Tickets list");
            model.addAttribute("tickets", ticketsPage);

            return "/admin/ticket";
        }

        Page<Ticket> ticketsPage = ticketService.getTickets(paging);
            int totalPages = ticketsPage.getTotalPages();
            if (totalPages > 0) {
                List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                        .boxed()
                        .collect(Collectors.toList());
                model.addAttribute("pageNumbers", pageNumbers);
            }


        model.addAttribute("title", "Admin - Tickets list");
        model.addAttribute("tickets", ticketsPage);


        return "/admin/ticket";
        } catch (Exception e) {
            return "Exception"+e;
        }
    }


}
