package org.example.springapi.repository;

import java.util.Optional;

import org.example.springapi.domain.models.User;
import org.example.springapi.repository.interfaces.IUserRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository implements IUserRepository {

    @Override
    public Optional<User> findByEmail(String email) {
        throw new UnsupportedOperationException("Unimplemented method 'findByEmail'");
    }
}
