package org.example.springapi.service;

import java.util.Optional;

import org.example.springapi.repository.interfaces.IUserRepository;
import org.example.springapi.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    private IUserRepository userRepository;

    @Autowired
    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<Integer> getUser(Integer id) {
        return Optional.ofNullable(id);
    }
}
