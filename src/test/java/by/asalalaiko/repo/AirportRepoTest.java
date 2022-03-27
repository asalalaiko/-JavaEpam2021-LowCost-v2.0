package by.asalalaiko.repo;

import by.asalalaiko.domain.Airport;
import by.asalalaiko.domain.City;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@ActiveProfiles("test")
public class AirportRepoTest {

    @Autowired
    private AirportRepo airportRepo;
    @Autowired
    private CityRepo cityRepo;


    @Test
    public void createAirport(){
        City city = setCity();
        cityRepo.save(city);
        Airport airport = setAirport();
        airport.setCity(city);
        airportRepo.save(airport);
        assertEquals(airportRepo.findAll().size(), 1);
        airportRepo.delete(airport);
    }



    @Test
    public void updateAirport(){
        Airport airport = setAirport();
        airport.setName("Vilnus  Fly");
        airportRepo.save(airport);
        assertEquals(airportRepo.getOne(airport.getId()).getName(), "Vilnus  Fly");
    }


    @Test
    public void deleteAirport(){
        Airport airport = setAirport();
        airport.setName("NY Fly");
        airportRepo.save(airport);
        airportRepo.delete(airport);
        assertEquals(airportRepo.findAll().size(), 0);
    }

    @Test
    public void findAllAirport(){

        City city = setCity();
        cityRepo.save(city);

        for(int i = 0; i<100; i++){
            Airport airport = setAirport();
            airport.setCity(city);
            airport.setName("Airport"+ i);
            airportRepo.save(airport);
        }
        assertEquals(airportRepo.findAll().size(), 100);
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
