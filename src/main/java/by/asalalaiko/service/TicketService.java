package by.asalalaiko.service;

import by.asalalaiko.domain.Ticket;

import java.util.List;

public interface TicketService {

    Ticket getTicketById (Long id);

    List<Ticket> getTickets();

    void createTicket(Ticket ticket);

    void updateTicket(Ticket ticket);

    public void deleteById (Long id);


}
