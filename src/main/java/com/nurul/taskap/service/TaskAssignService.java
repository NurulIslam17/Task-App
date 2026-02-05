package com.nurul.taskap.service;

import com.nurul.taskap.dto.task.TaskDto;
import com.nurul.taskap.dto.taskAssign.TaskAssignDto;
import com.nurul.taskap.dto.taskAssign.TaskAssignRequestDto;
import com.nurul.taskap.dto.user.UserDto;
import com.nurul.taskap.entity.AppUser;
import com.nurul.taskap.entity.Task;
import com.nurul.taskap.entity.TaskAssign;
import com.nurul.taskap.repository.TaskAssignRepository;
import com.nurul.taskap.utils.SecurityUtil;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskAssignService {

    private final TaskAssignRepository taskAssignRepository;
    private final TaskService taskService;
    private final UserService userService;
    private final ModelMapper modelMapper;
    private final SecurityUtil securityUtil;

    public TaskAssignService(TaskAssignRepository taskAssignRepository, TaskService taskService, UserService userService, ModelMapper modelMapper, SecurityUtil securityUtil) {
        this.taskAssignRepository = taskAssignRepository;
        this.taskService = taskService;
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.securityUtil = securityUtil;
    }

    public void assignTask(TaskAssignRequestDto taskAssignRequestDto) {

        Task task = taskService.findById(taskAssignRequestDto.getTaskId());
        AppUser appUser = userService.findById(taskAssignRequestDto.getUserId());
        AppUser tlUser = userService.findById(taskAssignRequestDto.getTeamLeadId());

        TaskAssign taskAssign = new TaskAssign();
        taskAssign.setTask(task);
        taskAssign.setUser(appUser);
        taskAssign.setTeamLead(tlUser);
        taskAssign.setDescription(taskAssignRequestDto.getDescription());
        taskAssignRepository.save(taskAssign);
    }


    public List<TaskAssignDto> assignList() {

        List<TaskAssign> taskAssignDtos;
        String username = securityUtil.getCurrentUsername();
        AppUser appUser = userService.findByName(username);
        Long id = appUser.getId();
        //  check ROLE_TL
        boolean isTeamLead = securityUtil.hasRole("ROLE_TL");
        if (!isTeamLead) {
            taskAssignDtos = taskAssignRepository.findAll();
        }else {
            taskAssignDtos = taskAssignRepository.findByTeamLead(id);
        }
        return taskAssignDtos
                .stream()
                .map(taskAssign -> modelMapper.map(taskAssign, TaskAssignDto.class))
                .toList();
    }
}
