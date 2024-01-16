package org.example.springapi.api.controller;

import org.example.springapi.api.model.PostUserRequest;
import org.example.springapi.api.model.User;
import org.example.springapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable Integer id){
        Optional<User> user = userService.getUser(id);

        if(user.isPresent())
            return new ResponseEntity<>(user.get(), HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/user")
    public ResponseEntity<Integer> postUser(@RequestBody PostUserRequest user) throws Exception {
        int userId = userService.createUser(user);

        return new ResponseEntity<>(userId, HttpStatus.CREATED);
    }
}