package com.nurul.taskap.dto.taskAssign;

import com.nurul.taskap.entity.AppUser;
import com.nurul.taskap.entity.Task;

public class TaskAssignDto {
    private Long id;
    private Task task;
    private AppUser teamLead;
    private AppUser user;
    private String description;

    public TaskAssignDto() {

    }

    public TaskAssignDto(Long id, Task task, AppUser teamLead, AppUser user, String description) {
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

    @Override
    public String toString() {
        return "TaskAssignDto{" +
                "id=" + id +
                ", task=" + task +
                ", teamLead=" + teamLead +
                ", user=" + user +
                ", description='" + description + '\'' +
                '}';
    }
}
