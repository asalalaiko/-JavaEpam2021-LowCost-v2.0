package by.asalalaiko.service.impl;

import by.asalalaiko.domain.User;
import by.asalalaiko.domain.UsersRole;
import by.asalalaiko.repo.UserRepo;
import by.asalalaiko.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Service
public class JPAUserService implements UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public void lockUnlockById(Long id) {}

    @Override
    public User activateUser(String code) {
        return null;
    }

    @Override
    public User findByLogin(String login) {
        return userRepo.findByLogin(login);
    }

    @Override
    public boolean addUser(User user) {
        User userFromDb = userRepo.findByLogin(user.getLogin());
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());


        if (userFromDb != null) {
            return false;
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setCreated(timestamp.toLocalDateTime());
        user.setActive(false); // new User don't activated
        user.setLocked(false); // new User don't locked
        user.setRole(UsersRole.USER);
        user.setActionCode(UUID.randomUUID().toString());


        saveUser(user);
        return true;
    }

    @Override
    public void saveUser(User user) {
        userRepo.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepo.findAll();
    }


}
