package org.example.springapi.api.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

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

    private IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user/register")
    public ResponseEntity<Map<String, Object>> postUserRegister(@RequestBody Object request) {

        Map<String, Object> object = new HashMap<>();
        object.put("register", 1);
        return new ResponseEntity<>(object, HttpStatus.OK);
    }

    @PostMapping("/user/login")
    public ResponseEntity<Map<String, Object>> postUserLogin(@RequestBody Object request) {

        Map<String, Object> object = new HashMap<>();
        object.put("login", 1);
        return new ResponseEntity<>(object, HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Integer> getUser(@PathVariable Integer id) {
        Optional<Integer> user = userService.getUser(id);

        if (user.isPresent())
            return new ResponseEntity<>(user.get(), HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}