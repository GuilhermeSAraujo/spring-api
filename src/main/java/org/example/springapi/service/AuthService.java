package org.example.springapi.service;

import java.util.Optional;

import org.example.springapi.domain.models.User;
import org.example.springapi.repository.interfaces.IUserRepository;
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
    public Optional<RegisterOutput> register(RegisterInput input) {
        Optional<User> user = userRepository.findByEmail(input.getEmail());

        if (user.isPresent()) {
            return Optional.of(new RegisterOutput(user.get().getEmail()));
        } else {
            return Optional.empty();
        }
    }
}
