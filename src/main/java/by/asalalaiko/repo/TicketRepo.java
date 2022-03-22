package by.asalalaiko.repo;


import by.asalalaiko.domain.Flight;
import by.asalalaiko.domain.Ticket;
import by.asalalaiko.domain.TicketStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepo extends JpaRepository<Ticket, Long> {
    List<Ticket> findByFlightAndStatus(Flight flight, TicketStatus ticketStatus);
}
