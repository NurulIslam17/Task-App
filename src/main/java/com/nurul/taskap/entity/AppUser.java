package com.nurul.taskap.entity;
import com.nurul.taskap.entity.type.RoleType;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "app_users")
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String userName;
    private String password;
    private String description;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "app_users_roles",
            joinColumns = @JoinColumn(name = "app_user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<Role> roles = new ArrayList<>();

    @OneToMany(mappedBy = "teamLead")
    private List<TaskAssign> assignedByMe = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<TaskAssign> assignedToMe = new ArrayList<>();

    public AppUser() {}

    public AppUser(Long id, String name, String userName, String password, String description, List<Role> roles, List<TaskAssign> assignedByMe, List<TaskAssign> assignedToMe) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.description = description;
        this.roles = roles;
        this.assignedByMe = assignedByMe;
        this.assignedToMe = assignedToMe;
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

    public List<TaskAssign> getAssignedByMe() {
        return assignedByMe;
    }

    public void setAssignedByMe(List<TaskAssign> assignedByMe) {
        this.assignedByMe = assignedByMe;
    }

    public List<TaskAssign> getAssignedToMe() {
        return assignedToMe;
    }

    public void setAssignedToMe(List<TaskAssign> assignedToMe) {
        this.assignedToMe = assignedToMe;
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", description='" + description + '\'' +
                ", roles=" + roles +
                ", assignedByMe=" + assignedByMe +
                ", assignedToMe=" + assignedToMe +
                '}';
    }
}
