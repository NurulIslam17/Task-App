package com.nurul.taskap.dto.taskAssign;

import com.nurul.taskap.entity.AppUser;
import com.nurul.taskap.entity.Task;

public class TaskAssignRequestDto {

    private Task task;
    private AppUser teamLead;
    private AppUser user;
    private String description;


    public TaskAssignRequestDto() {
    }

    public TaskAssignRequestDto(Task task, AppUser teamLead, AppUser user, String description) {
        this.task = task;
        this.teamLead = teamLead;
        this.user = user;
        this.description = description;
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
