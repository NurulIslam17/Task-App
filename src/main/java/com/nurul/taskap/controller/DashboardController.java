package com.nurul.taskap.controller;

import com.nurul.taskap.repository.DashboardCountProjection;
import com.nurul.taskap.service.DashboardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/dashboard")
    public String index(Model model)
    {
        DashboardCountProjection dashboardCountProjection = dashboardService.getDashboardCounts();

        model.addAttribute("dashboard",dashboardCountProjection);
        return "dashboard/index";
    }
}
