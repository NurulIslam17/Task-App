package com.nurul.taskap.controller;

import com.nurul.taskap.dto.task.TaskDto;
import com.nurul.taskap.dto.task.TaskRequestDto;
import com.nurul.taskap.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


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

    @GetMapping("/task/add")
    public String addTaskForm(Model model)
    {
        TaskRequestDto taskRequestDto = new TaskRequestDto();
        model.addAttribute("taskRequest",taskRequestDto);
        return "task/add";
    }

    @PostMapping("/task/add")
    public String addTask(@ModelAttribute("taskRequest") TaskRequestDto taskRequestDto)
    {
        System.out.println("Controller");
        System.out.println(taskRequestDto);
        taskService.addTask(taskRequestDto);
        return "redirect:/task/list?success";
    }
}
