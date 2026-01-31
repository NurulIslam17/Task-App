package com.nurul.taskap.service;

import com.nurul.taskap.repository.TaskAssignRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskAssignService {

    private final TaskAssignRepository taskAssignRepository;

    public TaskAssignService(TaskAssignRepository taskAssignRepository) {
        this.taskAssignRepository = taskAssignRepository;
    }
}
