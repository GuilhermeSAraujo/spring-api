package org.example.springapi.service.interfaces;

import java.util.Optional;

public interface IUserService {
    public Optional<Integer> getUser(Integer id);
}
