package org.example.springapi.service;

import java.util.Optional;

import org.example.springapi.domain.models.User;
import org.example.springapi.repository.interfaces.IUserRepository;
import org.example.springapi.repository.models.user.CreateUserRequest;
import org.example.springapi.service.DTOs.auth.RegisterInput;
import org.example.springapi.service.DTOs.auth.RegisterOutput;
import org.example.springapi.service.interfaces.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements IAuthService {
    private IUserRepository userRepository;

    @Autowired
    public AuthService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public RegisterOutput register(RegisterInput input) {
        User user = userRepository.findByEmail(input.getEmail());

        if (user != null)
            return new RegisterOutput(user.getEmail());

        CreateUserRequest createdUser = new CreateUserRequest(input.getName(), input.getAge(), input.getEmail(),
                input.getPassword());

        String createdUserEmail = userRepository.create(createdUser);

        return new RegisterOutput(createdUserEmail);
    }
}
