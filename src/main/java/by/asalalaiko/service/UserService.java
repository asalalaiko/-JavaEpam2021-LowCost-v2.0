package by.asalalaiko.service;

import by.asalalaiko.domain.User;

public interface UserService {

    void lockUnlockById(Long id);

    User activateUser(String code);

    User findByLogin(String login);


}
