package com.nurul.taskap.service;

import com.nurul.taskap.dto.task.TaskDto;
import com.nurul.taskap.dto.task.TaskRequestDto;
import com.nurul.taskap.entity.Task;
import com.nurul.taskap.repository.TaskRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

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

        System.out.println("Service");
        System.out.println(taskRequestDto);
        Task task = modelMapper.map(taskRequestDto, Task.class);
        taskRepository.save(task);
    }
}
