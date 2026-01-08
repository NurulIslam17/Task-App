package com.nurul.taskap.entity;

import com.nurul.taskap.enumType.TaskStatus;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Date startedAt;
    private Date endedAt;
    @Enumerated(value = EnumType.STRING)
    private TaskStatus status;

    public Task() {}

    public Task(Long id, String name, String description, Date startedAt, Date endedAt, TaskStatus status) {
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
}
