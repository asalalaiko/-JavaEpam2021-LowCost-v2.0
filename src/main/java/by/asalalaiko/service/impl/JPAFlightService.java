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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class JPAFlightService implements FlightService {

    @Value("${coefficient.min.profit}")
    private BigDecimal minProfit;
    @Value("${coefficient.baggage}")
    private BigDecimal cBaggage;
    @Value("${coefficient.priority}")
    private BigDecimal cPriority;

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

        Integer seats = flight.getPlane().getPassenger_seats();
        Integer km = flight.getKm();
        BigDecimal costKm = flight.getPlane().getCost_1km();
        BigDecimal taxStartAirport = flight.getStartAirport().getTax();
        BigDecimal taxFinishAirport = flight.getFinishAirport().getTax();
        BigDecimal costFlight = costKm.multiply(BigDecimal.valueOf(km)).add(taxStartAirport).add(taxFinishAirport);
        BigDecimal costTicket = costFlight.divide(BigDecimal.valueOf(seats),2);
        BigDecimal costBaggage = costTicket.multiply(cBaggage);
        BigDecimal costPriority = costTicket.multiply(cPriority);

        flight.setProfit(minProfit);
        flight.setMin_ticket_cost(costTicket);
        flight.setCostBaggage(costBaggage);
        flight.setCostPriority(costPriority);
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
