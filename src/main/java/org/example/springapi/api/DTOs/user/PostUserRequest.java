package org.example.springapi.api.DTOs.user;

public class PostUserRequest {
    private String name;
    private int age;
    private String email;

    public PostUserRequest(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public boolean isValid() {
        return !this.name.isBlank() && this.age >= 0 && !this.email.isBlank();
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
}
