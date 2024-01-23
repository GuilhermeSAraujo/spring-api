package org.example.springapi.service;

import java.util.Optional;

import org.example.springapi.domain.models.User;
import org.example.springapi.repository.interfaces.IUserRepository;
import org.example.springapi.repository.models.user.CreateRequest;
import org.example.springapi.service.DTOs.user.RegisterInput;
import org.example.springapi.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public Optional<Integer> getUser(Integer id) {
        return Optional.ofNullable(id);
    }

    @Override
    public String register(RegisterInput input) throws Exception {
        if (!input.isValid())
            throw new Exception("Invalid user.");

        User user = userRepository.findByEmail(input.getEmail());

        if (user != null)
            throw new Exception("User already exists.");

        String userEmail = userRepository.create(
                new CreateRequest(input.getName(), input.getAge(), input.getEmail(), input.getPassword()));

        return userEmail;
    }
}
