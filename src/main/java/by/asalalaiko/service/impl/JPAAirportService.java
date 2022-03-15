package by.asalalaiko.service.impl;

import by.asalalaiko.domain.Airport;
import by.asalalaiko.domain.City;
import by.asalalaiko.repo.AirportRepo;
import by.asalalaiko.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JPAAirportService implements AirportService {

    @Autowired
    private AirportRepo airportRepo;

    @Override
    public Airport getAirportById(Long id) {
        return airportRepo.getOne(id);
    }

    @Override
    public List<Airport> getAirports() {
        return airportRepo.findAll();
    }

    @Override
    public void createAirport(Airport airport) {
        airportRepo.save(airport);
    }

    @Override
    public void updateAirport(Airport airport) {
        airportRepo.save(airport);
    }

    @Override
    public void deleteById(Long id) {
        airportRepo.deleteById(id);
    }
}
