package com.orbedeveloper.todoapi.service;

import com.orbedeveloper.todoapi.dto.TaskInDTO;
import com.orbedeveloper.todoapi.exceptions.ToDoExceptions;
import com.orbedeveloper.todoapi.mapper.TaskInDTOToTask;
import com.orbedeveloper.todoapi.persistence.entity.Task;
import com.orbedeveloper.todoapi.persistence.entity.TaskStatus;
import com.orbedeveloper.todoapi.persistence.repository.TaskRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository repository;
    private final TaskInDTOToTask mapper;

    public TaskService(TaskRepository repository, TaskInDTOToTask mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Task createTask(TaskInDTO taskInDTO) {
        Task task = mapper.map(taskInDTO);
        return this.repository.save(task);
    }

    public List<Task> findAll() {
        return this.repository.findAll();
    }

    public Task findById(Long id) {
        return this.repository.findById(id).orElseThrow(() -> new ToDoExceptions("Task not found!", HttpStatus.NOT_FOUND));
    }

    public List<Task> findAllByTaskStatus(TaskStatus status) {
        return this.repository.findAllByTaskStatus(status);
    }

    @Transactional
    public void markTaskAsFinished(Long id) {
        if (!repository.existsById(id)) {
            throw new ToDoExceptions("Task not found!", HttpStatus.NOT_FOUND);
        }

        this.repository.markTaskAsFinished(id);
    }

    @Transactional
    public void update(Long id, TaskInDTO taskInDTO) {
        if (!repository.existsById(id)){
            throw new ToDoExceptions("Task not found!", HttpStatus.NOT_FOUND);
        }
        Task task = mapper.map(taskInDTO);
        task.setId(id);
        this.repository.save(task);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ToDoExceptions("Task not found!", HttpStatus.NOT_FOUND);
        }
        this.repository.deleteById(id);
    }
}