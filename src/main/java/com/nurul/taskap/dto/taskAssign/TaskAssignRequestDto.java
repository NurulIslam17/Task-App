package com.nurul.taskap.dto.taskAssign;

public class TaskAssignRequestDto {

    private Long taskId;
    private Long teamLeadId;
    private Long userId;
    private String description;


    public TaskAssignRequestDto() {
    }

    public TaskAssignRequestDto(Long taskId, Long teamLeadId, Long userId, String description) {
        this.taskId = taskId;
        this.teamLeadId = teamLeadId;
        this.userId = userId;
        this.description = description;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Long getTeamLeadId() {
        return teamLeadId;
    }

    public void setTeamLeadId(Long teamLeadId) {
        this.teamLeadId = teamLeadId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "TaskAssignRequestDto{" +
                "taskId=" + taskId +
                ", teamLeadId=" + teamLeadId +
                ", userId=" + userId +
                ", description='" + description + '\'' +
                '}';
    }
}
