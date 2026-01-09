package com.nurul.taskap.repository;

public interface DashboardCountProjection {
    Long getTotalUsers();
    Long getTotalTask();
    Long getActiveTask();
    Long getPendingTask();
    Long getInProgressTask();
    Long getCompleteTask();
    Long getMissedTask();
    Long getPostponeTask();
    Long getBacklogTask();
}
