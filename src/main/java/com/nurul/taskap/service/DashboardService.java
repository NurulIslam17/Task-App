package com.nurul.taskap.service;

import com.nurul.taskap.repository.DashboardCountProjection;
import com.nurul.taskap.repository.DashboardRepository;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    private final DashboardRepository dashboardRepository;

    public DashboardService(DashboardRepository dashboardRepository) {
        this.dashboardRepository = dashboardRepository;
    }

    public DashboardCountProjection getDashboardCounts() {
        return dashboardRepository.getDashboardCounts();
    }
}
