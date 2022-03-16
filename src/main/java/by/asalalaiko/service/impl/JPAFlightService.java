package by.asalalaiko.service.impl;

import by.asalalaiko.domain.Flight;
import by.asalalaiko.domain.Plane;
import by.asalalaiko.repo.FlightRepo;
import by.asalalaiko.repo.PlaneRepo;
import by.asalalaiko.service.FlightService;
import by.asalalaiko.service.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JPAFlightService implements FlightService {

    @Autowired
    private FlightRepo flightRepo;

    @Override
    public Flight getFlightById(Long id) {
        return flightRepo.getOne(id);
    }

    @Override
    public List<Flight> getFlights() {
        return flightRepo.findAll();
    }

    @Override
    public void createFlight(Flight flight) {
        flightRepo.save(flight);
    }

    @Override
    public void updateFlight(Flight plane) { flightRepo.save(plane);
    }
    @Override
    public void deleteById(Long id) {
        flightRepo.deleteById(id);
    }
}
