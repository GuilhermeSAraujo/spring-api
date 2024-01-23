package org.example.springapi.api.controller;

import java.util.Optional;

import org.example.springapi.api.DTOs.auth.PostAuthRegisterRequest;
import org.example.springapi.service.DTOs.auth.RegisterInput;
import org.example.springapi.service.DTOs.auth.RegisterOutput;
import org.example.springapi.service.interfaces.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    private IAuthService authService;

    @Autowired
    public AuthController(IAuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/auth/register")
    public ResponseEntity<RegisterOutput> postAuthRegister(@RequestBody PostAuthRegisterRequest request) {
        RegisterOutput register = authService.register(
                new RegisterInput(
                        request.getName(),
                        request.getAge(),
                        request.getEmail(),
                        request.getPassword()));

        if (register != null)
            return new ResponseEntity<>(register, HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
