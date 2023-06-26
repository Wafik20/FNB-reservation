package org.fnb.reservation.services;

import org.fnb.reservation.models.User;
import org.fnb.reservation.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User addUser(User user) {
        userRepository.save(user);
        return user;
    }

    public User getUser(String id) {
        try {
            if (userRepository.findById(id).isEmpty()) {
                throw new RuntimeException("User not found");
            }
            return userRepository.findById(id).get();
        } catch (Exception e) {
            throw new RuntimeException("User not found");
        }
    }
}
