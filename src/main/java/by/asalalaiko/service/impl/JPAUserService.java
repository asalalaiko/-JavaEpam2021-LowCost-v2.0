package by.asalalaiko.service.impl;

import by.asalalaiko.domain.User;
import by.asalalaiko.service.UserService;

public class JPAUserService implements UserService {

    @Override
    public void lockUnlockById(Long id) {

    }

    @Override
    public User activateUser(String code) {
        return null;
    }

    @Override
    public User findByLogin(String login) {
        return null;
    }
}
