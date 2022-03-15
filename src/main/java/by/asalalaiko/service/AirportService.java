package by.asalalaiko.service;

import by.asalalaiko.domain.Airport;
import by.asalalaiko.domain.City;

import java.util.List;

public interface AirportService {

    Airport getAirportById (Long id);

    List<Airport> getAirports();

    void createAirport(Airport airport);

    void updateAirport(Airport airport);

    public void deleteById (Long id);

}
