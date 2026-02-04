package com.nurul.taskap.controller;

import com.nurul.taskap.dto.task.TaskDto;
import com.nurul.taskap.dto.taskAssign.TaskAssignDto;
import com.nurul.taskap.dto.taskAssign.TaskAssignRequestDto;
import com.nurul.taskap.dto.user.UserDto;
import com.nurul.taskap.entity.Task;
import com.nurul.taskap.service.TaskAssignService;
import com.nurul.taskap.service.TaskService;
import com.nurul.taskap.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TaskAssignController {

    private final TaskAssignService taskAssignService;
    private final TaskService taskService;
    private final UserService userService;

    public TaskAssignController(TaskAssignService taskAssignService, TaskService taskService, UserService userService) {
        this.taskAssignService = taskAssignService;
        this.taskService = taskService;
        this.userService = userService;
    }

    @GetMapping("/task/assign/list")
    public String assignList(TaskAssignDto taskAssignDto, Model model)
    {
        List<TaskAssignDto> taskAssignDtos = taskAssignService.assignList();
        model.addAttribute("assignList", taskAssignDtos);
        return "taskAssign/list";
    }


    @GetMapping("/task/assign")
    public String assignTaskToUser(@RequestParam("id") Long id, Model model)
    {
        Task task = taskService.findById(id);
        TaskAssignRequestDto taskAssignRequestDto = new TaskAssignRequestDto();
        taskAssignRequestDto.setTaskId(id);
        List<UserDto> users = userService.getUserList("ROLE_USER");
        List<UserDto> teamLeads = userService.getUserList("ROLE_TL");

        model.addAttribute("taskAssignData", taskAssignRequestDto);
        model.addAttribute("taskDto", task);
        model.addAttribute("users",users);
        model.addAttribute("tls",teamLeads);
        return "taskAssign/add";
    }

    @PostMapping("/task/assign")
    public String assignTask(@ModelAttribute("taskAssignData") TaskAssignRequestDto taskAssignRequestDto)
    {
        System.out.println(taskAssignRequestDto);
        taskAssignService.assignTask(taskAssignRequestDto);
        return "redirect:/task/list";
    }
}
