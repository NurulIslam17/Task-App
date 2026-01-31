package com.nurul.taskap.repository;

import com.nurul.taskap.entity.TaskAssign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskAssignRepository extends JpaRepository<TaskAssign, Long> {
}
