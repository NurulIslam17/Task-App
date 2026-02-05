package com.nurul.taskap.controller;

import com.nurul.taskap.dto.task.TaskDto;
import com.nurul.taskap.repository.DashboardCountProjection;
import com.nurul.taskap.service.DashboardService;
import com.nurul.taskap.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DashboardController {

    private final DashboardService dashboardService;
    private final TaskService taskService;

    public DashboardController(DashboardService dashboardService, TaskService taskService) {
        this.dashboardService = dashboardService;
        this.taskService = taskService;
    }

    @GetMapping("/dashboard")
    public String index(Model model)
    {
        DashboardCountProjection dashboardCountProjection = dashboardService.getDashboardCounts();
        List<TaskDto> taskDtos = taskService.taskByAuthUserName();

        model.addAttribute("dashboard",dashboardCountProjection);
        model.addAttribute("userTask",taskDtos);
        return "dashboard/index";
    }
}
