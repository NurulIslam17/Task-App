package com.nurul.taskap.service;

import com.nurul.taskap.dto.task.TaskDto;
import com.nurul.taskap.dto.task.TaskRequestDto;
import com.nurul.taskap.entity.AppUser;
import com.nurul.taskap.entity.Task;
import com.nurul.taskap.enumType.TaskStatus;
import com.nurul.taskap.repository.TaskRepository;
import com.nurul.taskap.utils.SecurityUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final SecurityUtil securityUtil;


    public TaskService(TaskRepository taskRepository, ModelMapper modelMapper, UserService userService, SecurityUtil securityUtil) {
        this.taskRepository = taskRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.securityUtil = securityUtil;
    }

    public List<TaskDto> getTaskList() {
        List<Task> taskList = taskRepository.findUnassignedTasks();
        return taskList
                .stream()
                .map(task -> modelMapper.map(task, TaskDto.class))
                .toList();
    }

    public void addTask(TaskRequestDto taskRequestDto) {
        Task task = modelMapper.map(taskRequestDto, Task.class);
        taskRepository.save(task);
    }

    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }

    public TaskDto getById(Long id) {
        Optional<Task> task =  taskRepository.findById(id);
        return modelMapper.map(task,TaskDto.class);
    }



    public Task findById(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() ->new IllegalArgumentException("Task not found."));
        return task;
    }

    public void updateById(Long id, TaskRequestDto taskRequestDto) {
        Task taskData =modelMapper.map(taskRequestDto,Task.class);
        taskData.setId(id);
        taskRepository.save(taskData);
    }

    public List<TaskDto> findByStatus(TaskStatus status) {
        List<Task> taskList = taskRepository.findByStatus(status);
        return taskList
                .stream()
                .map(task -> modelMapper.map(task, TaskDto.class))
                .toList();
    }

    public List<TaskDto> taskByAuthUserName() {

        String name = securityUtil.getCurrentUsername();
        AppUser appUser = userService.findByName(name);
        List<Task> taskList = taskRepository.findTasksByUserId(appUser.getId());
        return taskList
                .stream()
                .map(task -> modelMapper.map(task,TaskDto.class))
                .toList();
    }
}
