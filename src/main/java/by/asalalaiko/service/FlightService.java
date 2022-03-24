package by.asalalaiko.service;

import by.asalalaiko.domain.Flight;
import by.asalalaiko.domain.FlightStatus;

import java.util.List;

public interface FlightService {

    Flight getFlightById (Long id);

    List<Flight> getFlights();

    List<Flight> getFlightsByStatus(FlightStatus flightStatus);

    void createFlight(Flight flight);

    void updateFlight(Flight flight);

    public void deleteById (Long id);

    void updateFlightToMidnight(Flight flight);



}
