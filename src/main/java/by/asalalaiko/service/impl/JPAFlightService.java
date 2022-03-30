package by.asalalaiko.service.impl;

import by.asalalaiko.domain.*;
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
    @Value("${coefficient.every.day}")
    private BigDecimal eDay;


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
    public List<Flight> getFlightsByStatus(FlightStatus flightStatus) {
        return flightRepo.findByStatus(flightStatus);
    }

//    when creating a new flight, the following are used for calculation:
//    the cost of airport tax (departure and reception), the distance between airports is multiplied by the cost of flying 1 km of the aircraft
//    minimum cost for one passenger - the total cost of the flight divided by the number of seats on the plane
//    The minimum profit is taken and the values in the profit settings are recalculated daily at midnight
//
//    ticket price is:
//    the minimum cost of a ticket for a flight is multiplied by profit
//    the cost of baggage is obtained: the cost of the ticket is multiplied by the coefficient
//    the cost of pre-booking is obtained: the cost of the ticket is multiplied by the coefficient
    @Override
    @Transactional
    public void createFlight(Flight flight) {

        Integer seats = flight.getPlane().getPassenger_seats();
        Integer km = flight.getKm();
        BigDecimal costKm = flight.getPlane().getCost_1km();
        BigDecimal taxStartAirport = flight.getStartAirport().getTax();
        BigDecimal taxFinishAirport = flight.getFinishAirport().getTax();
        BigDecimal costFlight = costKm.multiply(BigDecimal.valueOf(km)).add(taxStartAirport).add(taxFinishAirport);
        BigDecimal minCostTicket = costFlight.divide(BigDecimal.valueOf(seats),2);
        BigDecimal costTicket = minCostTicket.multiply(minProfit);
        BigDecimal costBaggage = costTicket.multiply(cBaggage);
        BigDecimal costPriority = costTicket.multiply(cPriority);

        flight.setProfit(minProfit);
        flight.setMin_ticket_cost(minCostTicket);
        flight.setTicket_cost(costTicket);
        flight.setCostBaggage(costBaggage);
        flight.setCostPriority(costPriority);
        flight.setStatus(FlightStatus.FREE);
        flightRepo.save(flight);
        
        for (int i=0; i<seats; i++){
            ticketRepo.save(new Ticket(flight, TicketStatus.FREE));
        }

    }




    @Override
    public void updateFlight(Flight plane) { flightRepo.save(plane);
    }


    @Override
    public void deleteById(Long id) {
        flightRepo.deleteById(id);
    }


    //weekly recalculation of the ticket price for the flight
    @Override
    public void updateFlightToMidnight(Flight flight) {
        BigDecimal profit = flight.getProfit().add(eDay);

        BigDecimal costTicket = flight.getMin_ticket_cost().multiply(profit);
        BigDecimal costBaggage = costTicket.multiply(cBaggage);
        BigDecimal costPriority = costTicket.multiply(cPriority);

        flight.setProfit(profit);
        flight.setCostBaggage(costBaggage);
        flight.setCostPriority(costPriority);
        flightRepo.save(flight);
    }
}
