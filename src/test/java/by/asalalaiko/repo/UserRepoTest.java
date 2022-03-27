package by.asalalaiko.repo;


import by.asalalaiko.domain.User;
import by.asalalaiko.domain.UsersRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@ActiveProfiles("test")
public class UserRepoTest {

    @Autowired
    private UserRepo userRepo;

    @Test
    public void saveUser() {
        User user = setAdmin();

        user.setLogin("user");
        userRepo.save(user);

        assertEquals(user.getLogin(), "user");
        assertEquals(userRepo.getOne(user.getId()), user);
    }

    @Test
    public void findUserByLogin() {
        User user = setUser();
        userRepo.save(user);
        assertEquals(user, userRepo.findByLogin("user"));

    }


    @Test
    public  void deleteUser(){
        User user = setUser();
        userRepo.save(user);
        assertEquals(user, userRepo.findByLogin("user"));
        userRepo.delete(user);
        assertEquals(userRepo.findByLogin("user"), null);
    }

    @Test
    public void findAllUser(){

        for(int i = 0; i<100; i++){
            User user = setUser();
            user.setLogin("user"+ i);
            userRepo.save(user);
        }
        assertEquals(userRepo.findAll().size(), 100);
    }


    private User setAdmin(){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        User user = new User();
        user.setEmail("user@gmail.com");
        user.setFirstName("Admin");
        user.setLastName("Adminov");
        user.setLocked(Boolean.FALSE);
        user.setCreated(timestamp.toLocalDateTime());
        user.setLogin("admin");
        user.setPassword("admin");
        user.setRole(UsersRole.ADMIN);
        user.setActive(Boolean.FALSE);
        user.setActionCode("0123456789");
        return user;
    }

    private User setUser(){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        User user = new User();
        user.setEmail("user@gmail.com");
        user.setFirstName("Ivan");
        user.setLastName("Ivanov");
        user.setLocked(Boolean.FALSE);
        user.setCreated(timestamp.toLocalDateTime());
        user.setLogin("user");
        user.setPassword("user");
        user.setRole(UsersRole.USER);
        user.setActive(Boolean.FALSE);
        user.setActionCode("0123456789");
        return user;
    }



}
