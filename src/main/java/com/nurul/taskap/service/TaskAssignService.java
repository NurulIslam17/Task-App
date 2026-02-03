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
        taskAssign.setTask(taskAssignRequestDto.getTask());
        taskAssign.setUser(taskAssignRequestDto.getUser());
        taskAssign.setTeamLead(taskAssignRequestDto.getTeamLead());
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
