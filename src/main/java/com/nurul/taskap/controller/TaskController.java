package com.nurul.taskap.controller;

import com.nurul.taskap.dto.task.TaskDto;
import com.nurul.taskap.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/task/list")
    public String getTaskList(Model model)
    {
        List<TaskDto> taskDtos = taskService.getTaskList();
        model.addAttribute("tasks", taskDtos);
        return "task/list";
    }
}
