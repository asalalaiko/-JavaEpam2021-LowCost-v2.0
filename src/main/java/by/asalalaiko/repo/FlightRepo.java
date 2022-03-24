package by.asalalaiko.repo;


import by.asalalaiko.domain.Flight;
import by.asalalaiko.domain.FlightStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepo extends JpaRepository<Flight, Long> {
    List<Flight> findByStatus (FlightStatus flightStatus);
}
