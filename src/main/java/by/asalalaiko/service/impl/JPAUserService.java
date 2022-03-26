package by.asalalaiko.service.impl;

import by.asalalaiko.domain.User;
import by.asalalaiko.domain.UsersRole;
import by.asalalaiko.mail.EmailService;
import by.asalalaiko.repo.UserRepo;
import by.asalalaiko.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class JPAUserService implements UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    public EmailService emailService;

    @Override
    public void lockUnlockById(Long id) {}

    @Override
    public User activateUser(String code) {

        User user =  userRepo.findByActionCode(code);
        if (user != null){
            user.setActive(Boolean.TRUE);
            userRepo.save(user);
        }

        return user;
    }


    @Override
    public User getUser(Long id) {
        return userRepo.getOne(id);
    }

    @Override
    public User getUserByLogin(String login) {
        return userRepo.findByLogin(login);
    }

    @Override
    public boolean addUser(User user) throws MessagingException {
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
        sendActivationCodeToUser(user);

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
        return userRepo.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }



    public void sendActivationCodeToUser(User user) throws MessagingException {
        String subject = "Send you activation code";
        String text = "To activate the user follow the link " +
                        "<a href='http://localhost:8080/activate?code=" + user.getActionCode() +
                        "'>ACTIVATE</a>";;

        emailService.sendHtmlMessage(user.getEmail(), subject, text);
    }


    }
