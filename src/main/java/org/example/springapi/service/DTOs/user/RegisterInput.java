package org.example.springapi.service.DTOs.user;

public class RegisterInput {
    private String name;
    private int age;
    private String email;
    private String password;

    public RegisterInput(String name, int age, String email, String passoword) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.password = passoword;
    }

    public boolean isValid() {
        return !this.name.isBlank() &&
                this.age >= 0 &&
                !this.email.isBlank() &&
                !this.password.isBlank();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
