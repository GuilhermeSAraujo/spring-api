package org.example.springapi.api.controller;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.example.springapi.api.DTOs.user.LoginRequest;
import org.example.springapi.api.DTOs.user.RegisterRequest;
import org.example.springapi.service.DTOs.user.RegisterInput;
import org.example.springapi.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/user/register")
    public ResponseEntity<String> postUserRegister(@RequestBody RegisterRequest request) throws Exception {
        String email = userService.register(
                new RegisterInput(request.getName(), request.getAge(), request.getEmail(), request.getPassword()));

        return new ResponseEntity<>(email, HttpStatus.CREATED);
    }

    @PostMapping("/user/login")
    public ResponseEntity<UserLoginOutput> postUserLogin(@RequestBody LoginRequest request) {
        UserLoginOutput userLogin = userService.login();

        return new ResponseEntity<>(userLogin, HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Integer> getUser(@PathVariable Integer id) {
        Optional<Integer> user = userService.getUser(id);

        if (user.isPresent())
            return new ResponseEntity<>(user.get(), HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
