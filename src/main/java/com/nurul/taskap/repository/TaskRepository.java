package com.nurul.taskap.repository;

import com.nurul.taskap.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {
}
