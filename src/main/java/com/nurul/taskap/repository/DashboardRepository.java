package com.nurul.taskap.repository;

import com.nurul.taskap.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DashboardRepository extends JpaRepository<AppUser,Long> {

    @Query(value = """
    SELECT
        (SELECT COUNT(*) FROM app_users) AS totalUsers,
        (SELECT COUNT(*) FROM tasks) AS totalTask,
        SUM(CASE WHEN status = 'ACTIVE' THEN 1 ELSE 0 END) AS activeTask,
        SUM(CASE WHEN status = 'PENDING' THEN 1 ELSE 0 END) AS pendingTask,
        SUM(CASE WHEN status = 'IN_PROGRESS' THEN 1 ELSE 0 END) AS inProgressTask,
        SUM(CASE WHEN status = 'COMPLETE' THEN 1 ELSE 0 END) AS completeTask,
        SUM(CASE WHEN status = 'MISSED' THEN 1 ELSE 0 END) AS missedTask,
        SUM(CASE WHEN status = 'POSTPONE' THEN 1 ELSE 0 END) AS postponeTask,
        SUM(CASE WHEN status = 'BACKLOG' THEN 1 ELSE 0 END) AS backlogTask
    FROM tasks
    """, nativeQuery = true)
    DashboardCountProjection getDashboardCounts();

}
