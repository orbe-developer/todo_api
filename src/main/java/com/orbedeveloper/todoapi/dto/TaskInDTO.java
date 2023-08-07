package com.orbedeveloper.todoapi.dto;



import lombok.Data;

import java.time.LocalDateTime;

@Data // getters and setters
public class TaskInDTO {
    private String title;
    private String description;
    private LocalDateTime eta; // Estimated Time of Arrival
}