package by.asalalaiko.service.impl;

import by.asalalaiko.domain.Flight;
import by.asalalaiko.domain.Plane;
import by.asalalaiko.domain.Ticket;
import by.asalalaiko.domain.TicketStatus;
import by.asalalaiko.repo.PlaneRepo;
import by.asalalaiko.repo.TicketRepo;
import by.asalalaiko.service.PlaneService;
import by.asalalaiko.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JPATicketService implements TicketService {

    @Autowired
    private TicketRepo ticketRepo;

    @Override
    public Ticket getTicketById(Long id) {
        return ticketRepo.getOne(id);
    }

    @Override
    public List<Ticket> getTickets() {
        return ticketRepo.findAll();
    }

    @Override
    public List<Ticket> getFreeTicketsToFlight(Flight flight) {

//        return ticketRepo.FindByFlightAndStatusTicket(flight, TicketStatus.FREE);
        return null;
    }

    @Override
    public void createTicket(Ticket ticket) {
        ticketRepo.save(ticket);
    }

    @Override
    public void updateTicket(Ticket ticket) {
        ticketRepo.save(ticket);
    }

    @Override
    public void deleteById(Long id) {
        ticketRepo.deleteById(id);
    }

}
