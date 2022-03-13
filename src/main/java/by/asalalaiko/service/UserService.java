package by.asalalaiko.service;

import by.asalalaiko.domain.User;

import javax.mail.MessagingException;
import java.util.List;

public interface UserService {

    void lockUnlockById(Long id);

    User activateUser(String code);

    User findByLogin(String login);

    boolean addUser(User user) throws MessagingException;

    public void saveUser(User user);

    void deleteUser(Long id);

     List<User> findAllUsers();
}
