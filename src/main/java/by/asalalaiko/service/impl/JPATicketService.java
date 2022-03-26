package by.asalalaiko.service.impl;

import by.asalalaiko.domain.*;
import by.asalalaiko.repo.PlaneRepo;
import by.asalalaiko.repo.TicketRepo;
import by.asalalaiko.service.PlaneService;
import by.asalalaiko.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Page<Ticket> getTickets(Pageable pageable) {
        return ticketRepo.findAll(pageable);
    }

    @Override
    public List<Ticket> getTicketsByOrder(Order order) {
        return ticketRepo.findByOrder(order);
    }

    @Override
    public Page<Ticket> getTicketsByFlight(Flight flight, Pageable pageable) {
        return ticketRepo.findByFlight(flight, pageable);
    }

    @Override
    public List<Ticket> getFreeTicketsToFlight(Flight flight) {

        return ticketRepo.findByFlightAndStatus(flight, TicketStatus.FREE);
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
