package org.example.springapi.service.interfaces;

import java.util.Optional;

import org.example.springapi.service.DTOs.user.RegisterInput;

public interface IUserService {
    public String register(RegisterInput input) throws Exception;

    public LoginUserOutput login(LoginUserInput input) throws Exception;

    public Optional<Integer> getUser(Integer id);
}
