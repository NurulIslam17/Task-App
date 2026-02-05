package com.nurul.taskap.entity;

import com.nurul.taskap.enumType.TaskStatus;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TaskAssign> taskAssigns = new ArrayList<>();

    public Task() {}

    public Task(Long id, String name, String description, Date startedAt, Date endedAt, TaskStatus status, List<TaskAssign> taskAssigns) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startedAt = startedAt;
        this.endedAt = endedAt;
        this.status = status;
        this.taskAssigns = taskAssigns;
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

    public List<TaskAssign> getTaskAssigns() {
        return taskAssigns;
    }

    public void setTaskAssigns(List<TaskAssign> taskAssigns) {
        this.taskAssigns = taskAssigns;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", startedAt=" + startedAt +
                ", endedAt=" + endedAt +
                ", status=" + status +
                ", taskAssigns=" + taskAssigns +
                '}';
    }
}
