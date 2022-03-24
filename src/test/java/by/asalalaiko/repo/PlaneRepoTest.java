package by.asalalaiko.repo;

import by.asalalaiko.domain.Plane;
import by.asalalaiko.domain.User;
import by.asalalaiko.domain.UsersRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@ActiveProfiles("test")
public class PlaneRepoTest {

    @Autowired
    private PlaneRepo planeRepo;

    @Test
    public void savePlane() {
        Plane plane = setPlane();

        planeRepo.save(plane);

        assertEquals(planeRepo.getOne(2L).getName(), plane.getName());
    }

    @Test
    public void deletePlane(){
        Plane plane = setPlane();
        planeRepo.save(plane);

        planeRepo.delete(plane);
        assertEquals(planeRepo.findAll().size(), 0);
    }

    @Test
    public void findAllPlane(){

        for(int i = 0; i<100; i++){
            Plane plane = setPlane();
            plane.setName("plane"+ i);
            planeRepo.save(plane);
        }
        assertEquals(planeRepo.findAll().size(), 100);
    }




    private Plane setPlane(){
        Plane plane = new Plane();
        plane.setName("VM 54585");
        plane.setModel("TU-154");
        plane.setPassenger_seats(180);
        plane.setCost_1km(BigDecimal.valueOf(10.00));
        return plane;
    }

}
