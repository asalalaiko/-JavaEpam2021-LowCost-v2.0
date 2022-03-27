package by.asalalaiko.repo;

import by.asalalaiko.domain.City;
import by.asalalaiko.domain.User;
import by.asalalaiko.domain.UsersRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@ActiveProfiles("test")
public class CityRepoTest {

    @Autowired
    private CityRepo cityRepo;

    @Test
    public void createCity(){
        City city = setCity();
        city.setName("NY");
        cityRepo.save(city);
        assertEquals(cityRepo.findAll().size(), 1);
        cityRepo.delete(city);
    }

    @Test
    public void updateCity(){
        City city = setCity();


        city.setName("Vilnus");
        cityRepo.save(city);

        assertEquals(cityRepo.getOne(city.getId()).getName(), "Vilnus");
    }

    @Test
    public void deleteCity(){
        City city = setCity();
        city.setName("NY");
        cityRepo.save(city);
        cityRepo.delete(city);
        assertEquals(cityRepo.findAll().size(), 0);
    }

    @Test
    public void findAllCity(){

        for(int i = 0; i<100; i++){
            City city = setCity();
            city.setName("City"+ i);
            cityRepo.save(city);
        }
        assertEquals(cityRepo.findAll().size(), 100);
    }


    private City setCity(){
        City city = new City();
        city.setName("London");
        return city;
    }
}
