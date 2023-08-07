package com.orbedeveloper.todoapi.controller;


import com.orbedeveloper.todoapi.dto.TaskInDTO;
import com.orbedeveloper.todoapi.persistence.entity.Task;
import com.orbedeveloper.todoapi.persistence.entity.TaskStatus;
import com.orbedeveloper.todoapi.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v1/tasks")
public class TaskController {
    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Task createTask(@RequestBody TaskInDTO taskInDTO) {
        return this.service.createTask(taskInDTO);
    }

    @GetMapping
    public List<Task> findAll() {
        return this.service.findAll();
    }

    @GetMapping("/{id}")
    public Task findById(@PathVariable Long id) {
        return this.service.findById(id);
    }

    @GetMapping("/status/{status}")
    public List<Task> findByStatus(@PathVariable TaskStatus status) {
        return this.service.findAllByTaskStatus(status);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("mark_as_finished/{id}")
    public void markAsFinished(@PathVariable Long id) {
        this.service.markTaskAsFinished(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody TaskInDTO taskInDTO, @PathVariable Long id) {
        this.service.update(id, taskInDTO);

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.service.delete(id);
    }
}