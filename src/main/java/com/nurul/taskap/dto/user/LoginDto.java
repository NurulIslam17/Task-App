package com.nurul.taskap.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class LoginDto {

    @NotEmpty(message = "Email should not be empty")
    @Email
    private String name;
    @NotEmpty(message = "Password should not be empty")
    private String password;

    public LoginDto() {}

    public LoginDto(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public @NotEmpty(message = "Email should not be empty") @Email String getName() {
        return name;
    }

    public void setName(@NotEmpty(message = "Email should not be empty") @Email String name) {
        this.name = name;
    }

    public @NotEmpty(message = "Password should not be empty") String getPassword() {
        return password;
    }

    public void setPassword(@NotEmpty(message = "Password should not be empty") String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginDto{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
