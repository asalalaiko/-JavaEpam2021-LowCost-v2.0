package by.asalalaiko.repo;

import by.asalalaiko.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByLogin(String login);
}
