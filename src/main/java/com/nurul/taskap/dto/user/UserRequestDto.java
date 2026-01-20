package com.nurul.taskap.dto.user;

import com.nurul.taskap.entity.type.RoleType;

import java.util.HashSet;
import java.util.Set;

public class UserRequestDto {
    private Long id;
    private String name;
    private String userName;
    private String password;
    private String description;
    Set<RoleType> roles = new HashSet<>();


    public UserRequestDto() { }

    public UserRequestDto(Long id, String name, String userName, String password, String description, Set<RoleType> roles) {
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

    public Set<RoleType> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleType> roles) {
        this.roles = roles;
    }

}
