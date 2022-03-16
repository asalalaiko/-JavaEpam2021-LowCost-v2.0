package by.asalalaiko.service;

import by.asalalaiko.domain.Flight;

import java.util.List;

public interface FlightService {

    Flight getFlightById (Long id);

    List<Flight> getFlights();

    void createFlight(Flight flight);

    void updateFlight(Flight flight);

    public void deleteById (Long id);


}
