package by.asalalaiko.repo;


import by.asalalaiko.domain.Plane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaneRepo extends JpaRepository<Plane, Long> {
}
