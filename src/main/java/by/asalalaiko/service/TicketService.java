package by.asalalaiko.service;

import by.asalalaiko.domain.Flight;
import by.asalalaiko.domain.Ticket;

import java.util.List;

public interface TicketService {

    Ticket getTicketById (Long id);

    List<Ticket> getTickets();

    List<Ticket> getFreeTicketsToFlight(Flight flight);

    void createTicket(Ticket ticket);

    void updateTicket(Ticket ticket);

    public void deleteById (Long id);


}
