package by.asalalaiko.repo;

import by.asalalaiko.domain.Airport;
import by.asalalaiko.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepo extends JpaRepository<Airport, Long> {
}
