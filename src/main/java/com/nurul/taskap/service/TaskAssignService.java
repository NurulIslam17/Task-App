package com.nurul.taskap.service;

import com.nurul.taskap.dto.taskAssign.TaskAssignRequestDto;
import com.nurul.taskap.entity.TaskAssign;
import com.nurul.taskap.repository.TaskAssignRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskAssignService {

    private final TaskAssignRepository taskAssignRepository;

    public TaskAssignService(TaskAssignRepository taskAssignRepository) {
        this.taskAssignRepository = taskAssignRepository;
    }

    public void assignTask(TaskAssignRequestDto taskAssignRequestDto) {

        TaskAssign taskAssign = new TaskAssign();
        taskAssign.setTask_id(taskAssignRequestDto.getTask_id());
        taskAssign.setUser_id(taskAssignRequestDto.getUser_id());
        taskAssign.setTl_id(taskAssignRequestDto.getTl_id());
        taskAssign.setDescription(taskAssignRequestDto.getDescription());
        taskAssignRepository.save(taskAssign);
    }
}
