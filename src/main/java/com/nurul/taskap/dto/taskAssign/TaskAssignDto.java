package com.nurul.taskap.dto.taskAssign;

public class TaskAssignDto {
    private Long id;
    private Long task_id;
    private Long tl_id;
    private Long user_id;
    private String description;

    public TaskAssignDto() {}

    public TaskAssignDto(Long id, Long task_id, Long tl_id, Long user_id, String description) {
        this.id = id;
        this.task_id = task_id;
        this.tl_id = tl_id;
        this.user_id = user_id;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTask_id() {
        return task_id;
    }

    public void setTask_id(Long task_id) {
        this.task_id = task_id;
    }

    public Long getTl_id() {
        return tl_id;
    }

    public void setTl_id(Long tl_id) {
        this.tl_id = tl_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
