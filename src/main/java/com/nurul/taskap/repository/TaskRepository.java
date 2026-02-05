package com.nurul.taskap.repository;

import com.nurul.taskap.entity.Task;
import com.nurul.taskap.enumType.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {
    List<Task> findByStatus(TaskStatus status);

    @Query("SELECT t FROM Task t LEFT JOIN t.taskAssigns ta WHERE ta.id IS NULL")
    List<Task> findUnassignedTasks();

    @Query("""
        SELECT DISTINCT t
        FROM Task t
        JOIN t.taskAssigns ta
        WHERE ta.user.id = :userId
    """)
    List<Task> findTasksByUserId(@Param("userId") Long userId);

}
