package by.asalalaiko.service;

import by.asalalaiko.domain.Flight;
import by.asalalaiko.domain.Order;
import by.asalalaiko.domain.Ticket;
import by.asalalaiko.domain.TicketStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TicketService {

    Ticket getTicketById (Long id);

    Page<Ticket> getTickets(Pageable pageable);

    List<Ticket> getTicketsByOrder(Order order);

    Page<Ticket> getTicketsByFlight(Flight flight, Pageable pageable);

    List<Ticket> getFreeTicketsToFlight(Flight flight);

    void createTicket(Ticket ticket);

    void updateTicket(Ticket ticket);

    public void deleteById (Long id);

}
