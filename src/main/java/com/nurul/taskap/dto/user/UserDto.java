package com.nurul.taskap.dto.user;

import com.nurul.taskap.entity.Role;

import java.util.ArrayList;
import java.util.List;

public class UserDto {

    private Long id;
    private String name;
    private String userName;
    private String password;
    private String description;
    private List<Role> roles = new ArrayList<>();

    public UserDto() {
    }

    public UserDto(Long id, String name, String userName, String password, String description, List<Role> roles) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.description = description;
        this.roles = roles;
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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
