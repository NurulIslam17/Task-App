package com.nurul.taskap.repository;

import com.nurul.taskap.entity.Task;
import com.nurul.taskap.enumType.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {
    List<Task> findByStatus(TaskStatus status);

    @Query("SELECT t FROM Task t LEFT JOIN t.taskAssigns ta WHERE ta.id IS NULL")
    List<Task> findUnassignedTasks();
}
