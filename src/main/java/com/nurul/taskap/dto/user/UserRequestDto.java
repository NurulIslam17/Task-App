package com.nurul.taskap.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;


public class UserRequestDto {
    private Long id;
    @NotEmpty(message = "Email should not be empty")
    @Email
    private String name;
    @NotEmpty(message = "User name should not be empty")
    private String userName;
    @NotEmpty(message = "Password should not be empty")
    private String password;
    private String description;

    public UserRequestDto() { }

    public UserRequestDto(Long id, String name, String userName, String password, String description) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "UserRequestDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
