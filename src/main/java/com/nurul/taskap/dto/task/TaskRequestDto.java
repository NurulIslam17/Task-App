package com.nurul.taskap.dto.task;

import com.nurul.taskap.enumType.TaskStatus;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class TaskRequestDto {

    private Long id;
    private String name;
    private String description;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startedAt;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endedAt;

    private TaskStatus status;

    public TaskRequestDto() {}

    public TaskRequestDto(Long id, String name, String description, Date startedAt, Date endedAt, TaskStatus status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startedAt = startedAt;
        this.endedAt = endedAt;
        this.status = status;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(Date startedAt) {
        this.startedAt = startedAt;
    }

    public Date getEndedAt() {
        return endedAt;
    }

    public void setEndedAt(Date endedAt) {
        this.endedAt = endedAt;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TaskRequestDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", startedAt=" + startedAt +
                ", endedAt=" + endedAt +
                ", status=" + status +
                '}';
    }
}
