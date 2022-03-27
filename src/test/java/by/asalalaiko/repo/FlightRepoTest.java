package by.asalalaiko.repo;


import by.asalalaiko.domain.Airport;
import by.asalalaiko.domain.City;
import by.asalalaiko.domain.Flight;
import by.asalalaiko.domain.Plane;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@ActiveProfiles("test")
public class FlightRepoTest {

    @Autowired
    private FlightRepo flightRepo;
    @Autowired
    private PlaneRepo planeRepo;
    @Autowired
    private CityRepo cityRepo;
    @Autowired
    private AirportRepo airportRepo;



    @Test
    public void createFlight(){
        Plane plane = setPlane();
        planeRepo.save(plane);
        City city = setCity();
        cityRepo.save(city);
        Airport airport = setAirport();
        airport.setCity(city);
        airportRepo.save(airport);

        Flight flight = new Flight();
        flight.setStartAirport(airport);
        flight.setFinishAirport(airport);
        flight.setPlane(plane);
        flightRepo.save(flight);
        assertEquals(cityRepo.findAll().size(), 1);

    }

    @Test
    public void updateFlight(){
        Plane plane = setPlane();
        planeRepo.save(plane);
        City city = setCity();
        cityRepo.save(city);
        Airport airport = setAirport();
        airport.setCity(city);
        airportRepo.save(airport);

        Flight flight = new Flight();
        flight.setStartAirport(airport);
        flight.setFinishAirport(airport);
        flight.setPlane(plane);
        flightRepo.save(flight);

        Plane plane2 = setPlane();
        plane2.setName("MI");
        planeRepo.save(plane2);

        flight.setPlane(plane2);
        flightRepo.save(flight);


        assertEquals(flightRepo.getOne(flight.getId()).getPlane().getName(), "MI");
    }


    private Plane setPlane(){
        Plane plane = new Plane();
        plane.setName("VM 54585");
        plane.setModel("TU-154");
        plane.setPassenger_seats(180);
        plane.setCost_1km(BigDecimal.valueOf(10.00));
        return plane;
    }

    private Airport setAirport(){
        Airport airport = new Airport();
        airport.setName("London Fly");
        return airport;
    }
    private City setCity(){
        City city = new City();
        city.setName("London");
        return city;
    }
}
