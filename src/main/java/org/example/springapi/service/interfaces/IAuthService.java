package org.example.springapi.service.interfaces;

import org.example.springapi.service.DTOs.auth.RegisterInput;
import org.example.springapi.service.DTOs.auth.RegisterOutput;

public interface IAuthService {
    RegisterOutput register(RegisterInput input);
}
