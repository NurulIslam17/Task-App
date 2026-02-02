package com.nurul.taskap.service;

import com.nurul.taskap.dto.taskAssign.TaskAssignDto;
import com.nurul.taskap.dto.taskAssign.TaskAssignRequestDto;
import com.nurul.taskap.entity.TaskAssign;
import com.nurul.taskap.repository.TaskAssignRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskAssignService {

    private final TaskAssignRepository taskAssignRepository;
    private final ModelMapper modelMapper;

    public TaskAssignService(TaskAssignRepository taskAssignRepository, ModelMapper modelMapper) {
        this.taskAssignRepository = taskAssignRepository;
        this.modelMapper = modelMapper;
    }

    public void assignTask(TaskAssignRequestDto taskAssignRequestDto) {

        TaskAssign taskAssign = new TaskAssign();
        taskAssign.setTask_id(taskAssignRequestDto.getTask_id());
        taskAssign.setUser_id(taskAssignRequestDto.getUser_id());
        taskAssign.setTl_id(taskAssignRequestDto.getTl_id());
        taskAssign.setDescription(taskAssignRequestDto.getDescription());
        taskAssignRepository.save(taskAssign);
    }


    public List<TaskAssignDto> assignList() {
        List<TaskAssign> taskAssignDtos = taskAssignRepository.findAll();
        return taskAssignDtos
                .stream()
                .map(taskAssign ->modelMapper.map(taskAssign,TaskAssignDto.class))
                .toList();
    }
}
