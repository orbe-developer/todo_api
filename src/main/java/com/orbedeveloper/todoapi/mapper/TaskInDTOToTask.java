package com.orbedeveloper.todoapi.mapper;

import com.orbedeveloper.todoapi.dto.TaskInDTO;
import com.orbedeveloper.todoapi.persistence.entity.Task;
import com.orbedeveloper.todoapi.persistence.entity.TaskStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TaskInDTOToTask implements IMapper<TaskInDTO, Task> {
    @Override
    public Task map(TaskInDTO in) {
        Task task = new Task();
        task.setTitle(in.getTitle());
        task.setDescription(in.getDescription());
        task.setEta(in.getEta());
        task.setCreatedDate(LocalDateTime.now());
        task.setFinished(false);
        task.setTaskStatus(TaskStatus.ON_TIME);
        return task;
    }
}