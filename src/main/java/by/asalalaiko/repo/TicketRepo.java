package by.asalalaiko.repo;


import by.asalalaiko.domain.Flight;
import by.asalalaiko.domain.Order;
import by.asalalaiko.domain.Ticket;
import by.asalalaiko.domain.TicketStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepo extends JpaRepository<Ticket, Long> {


    Page<Ticket> findByFlight(Flight flight, Pageable page);

    List<Ticket> findByFlightAndStatus(Flight flight, TicketStatus ticketStatus);

    List<Ticket> findByOrder(Order order);
}
