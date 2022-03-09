package by.asalalaiko.service.impl;

import by.asalalaiko.domain.User;
import by.asalalaiko.repo.UserRepo;
import by.asalalaiko.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JPAUserService implements UserService {

    @Autowired
    private UserRepo userRepo;


    @Override
    public void lockUnlockById(Long id) {}

    @Override
    public User activateUser(String code) {
        return null;
    }

    @Override
    public User findByLogin(String login) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }
}
