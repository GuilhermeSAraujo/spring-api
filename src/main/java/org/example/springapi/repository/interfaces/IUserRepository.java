package org.example.springapi.repository.interfaces;

import org.example.springapi.domain.models.User;
import org.example.springapi.repository.models.user.CreateUserRequest;

public interface IUserRepository {
    User findByEmail(String email);

    String create(CreateUserRequest request);
}
