package com.nurul.taskap.controller;

import com.nurul.taskap.dto.task.TaskDto;
import com.nurul.taskap.dto.taskAssign.TaskAssignRequestDto;
import com.nurul.taskap.service.TaskAssignService;
import com.nurul.taskap.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TaskAssignController {

    private final TaskAssignService taskAssignService;
    private final TaskService taskService;

    public TaskAssignController(TaskAssignService taskAssignService, TaskService taskService) {
        this.taskAssignService = taskAssignService;
        this.taskService = taskService;
    }
    @GetMapping("/task/assign")
    public String assignTaskToUser(@RequestParam("id") Long id, Model model)
    {
        TaskDto taskDto = taskService.findById(id);
        TaskAssignRequestDto taskAssignRequestDto = new TaskAssignRequestDto();

        model.addAttribute("taskAssignData", taskAssignRequestDto);
        model.addAttribute("taskDto", taskDto);
        return "taskAssign/add";
    }
}
