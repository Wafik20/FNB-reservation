package org.fnb.reservation.controllers;

import org.fnb.reservation.models.User;
import org.fnb.reservation.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User newUser) {
        User userCreated = userService.addUser(newUser);
        return new ResponseEntity<User>(userCreated, HttpStatus.CREATED);
    }
}
