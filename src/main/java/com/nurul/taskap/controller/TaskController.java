package com.nurul.taskap.controller;

import com.nurul.taskap.dto.task.TaskDto;
import com.nurul.taskap.dto.task.TaskRequestDto;
import com.nurul.taskap.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


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
        taskService.addTask(taskRequestDto);
        return "redirect:/task/list?success";
    }

    @GetMapping("/task/delete/{id}")
    public String deleteById(@PathVariable Long id)
    {
        taskService.deleteById(id);
        return "redirect:/task/list?deleted";
    }

    @GetMapping("/task/details/{id}")
    public String getById(@PathVariable Long id, Model model)
    {
        TaskDto taskDto = taskService.getById(id);
        model.addAttribute("task", taskDto);
        return "task/details";

    }

    @GetMapping("/task/edit/{id}")
    public String editTask(@PathVariable Long id, Model model) {
        TaskDto taskDto = taskService.findById(id);
        model.addAttribute("task", taskDto);
        return "task/edit";
    }

    @PostMapping("/task/update/{id}")
    public String updateById(@PathVariable Long id, @ModelAttribute("task") TaskRequestDto taskRequestDto) {
        taskService.updateById(id, taskRequestDto);
        return "redirect:/task/list?updated";
    }
}
