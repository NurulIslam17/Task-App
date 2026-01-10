package com.nurul.taskap.repository;

import com.nurul.taskap.entity.Task;
import com.nurul.taskap.enumType.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {
    List<Task> findByStatus(TaskStatus status);
}
