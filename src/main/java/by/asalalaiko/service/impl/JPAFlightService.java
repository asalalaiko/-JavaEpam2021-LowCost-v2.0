package by.asalalaiko.service.impl;

import by.asalalaiko.domain.Flight;
import by.asalalaiko.domain.Plane;
import by.asalalaiko.domain.Ticket;
import by.asalalaiko.domain.TicketStatus;
import by.asalalaiko.repo.FlightRepo;
import by.asalalaiko.repo.PlaneRepo;
import by.asalalaiko.repo.TicketRepo;
import by.asalalaiko.service.FlightService;
import by.asalalaiko.service.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JPAFlightService implements FlightService {

    @Autowired
    private FlightRepo flightRepo;
    @Autowired
    private TicketRepo ticketRepo;

    @Override
    public Flight getFlightById(Long id) {
        return flightRepo.getOne(id);
    }

    @Override
    public List<Flight> getFlights() {
        return flightRepo.findAll();
    }

    @Override
    @Transactional
    public void createFlight(Flight flight) {

        int seats = flight.getPlane().getPassenger_seats();
        flightRepo.save(flight);
        for (int i=0; i<seats; i++){
            ticketRepo.save(new Ticket(flight, TicketStatus.FREE));
        }
        ticketRepo.findAll();
    }

    @Override
    public void updateFlight(Flight plane) { flightRepo.save(plane);
    }


    @Override
    public void deleteById(Long id) {
        flightRepo.deleteById(id);
    }
}
