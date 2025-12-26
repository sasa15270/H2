package com.h2.H2.service;

import com.h2.H2.entity.User;
import com.h2.H2.repository.UserInterface;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserInterface userInterface;
    public UserService (UserInterface userInterface)
    {
        this.userInterface=userInterface;
    }
    public User register(User user)
    {
        try{
            return userInterface.save(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<User> login(String email, String password) {
        try {
            return userInterface.findByEmail(email)
                    .filter(u -> u.getPassword().equals(password));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
