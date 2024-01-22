package org.example.springapi.service.DTOs.auth;

public class RegisterOutput {
    private String email;

    public RegisterOutput(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
