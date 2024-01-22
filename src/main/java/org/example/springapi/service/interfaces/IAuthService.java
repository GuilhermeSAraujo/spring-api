package org.example.springapi.service.interfaces;

import java.util.Optional;

import org.example.springapi.service.DTOs.auth.RegisterInput;
import org.example.springapi.service.DTOs.auth.RegisterOutput;

public interface IAuthService {
    Optional<RegisterOutput> register(RegisterInput input);
}
