package org.example.springapi.repository.interfaces;

import java.util.Optional;

import org.example.springapi.domain.models.User;

public interface IUserRepository {
    Optional<User> findByEmail(String email);
}
