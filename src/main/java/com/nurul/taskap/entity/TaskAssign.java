package com.nurul.taskap.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "task_assigns")
public class TaskAssign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id", nullable = false)
    private Task task;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tl_id", nullable = false)
    private AppUser teamLead;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private AppUser user;

    private String description;

    public TaskAssign() {}

    public TaskAssign(Long id, Task task, AppUser teamLead, AppUser user, String description) {
        this.id = id;
        this.task = task;
        this.teamLead = teamLead;
        this.user = user;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public AppUser getTeamLead() {
        return teamLead;
    }

    public void setTeamLead(AppUser teamLead) {
        this.teamLead = teamLead;
    }

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
