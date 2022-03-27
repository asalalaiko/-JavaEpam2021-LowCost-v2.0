package by.asalalaiko.service.impl;

import by.asalalaiko.domain.User;
import by.asalalaiko.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserAuthService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepo.findByLogin(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found, or don't activated");
        }
        if (user.getActive()==false) {
            throw new UsernameNotFoundException("User don't activated");
        }
        if (user.getLocked()) {
            throw new UsernameNotFoundException("User locked");
        }
        return user;
    }
}
