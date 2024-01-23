package org.example.springapi.repository.interfaces;

import org.example.springapi.domain.models.User;

public interface IUserRepository {
    User findByEmail(String email);
}
