package by.asalalaiko.service;

import by.asalalaiko.domain.User;

import java.util.List;

public interface UserService {

    void lockUnlockById(Long id);

    User activateUser(String code);

    User findByLogin(String login);

     List<User> findAll();
}
