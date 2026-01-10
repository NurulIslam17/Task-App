package com.nurul.taskap.service;

import com.nurul.taskap.dto.task.TaskDto;
import com.nurul.taskap.dto.task.TaskRequestDto;
import com.nurul.taskap.entity.Task;
import com.nurul.taskap.enumType.TaskStatus;
import com.nurul.taskap.repository.TaskRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final ModelMapper modelMapper;


    public TaskService(TaskRepository taskRepository, ModelMapper modelMapper) {
        this.taskRepository = taskRepository;
        this.modelMapper = modelMapper;
    }

    public List<TaskDto> getTaskList() {
        List<Task> taskList = taskRepository.findAll();
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

    public TaskDto findById(Long id) {
        Optional<Task> task = taskRepository.findById(id);
        return modelMapper.map(task,TaskDto.class);
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
}
