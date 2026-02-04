package com.nurul.taskap.repository;

import com.nurul.taskap.entity.TaskAssign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskAssignRepository extends JpaRepository<TaskAssign, Long> {

    @Query("SELECT ta FROM TaskAssign ta JOIN FETCH ta.task JOIN FETCH ta.user WHERE ta.teamLead.id = :id")
    List<TaskAssign> findByTeamLead(Long id);
}
