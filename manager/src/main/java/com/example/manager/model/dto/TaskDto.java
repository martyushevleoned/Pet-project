package com.example.manager.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskDto {
    private Long id;
    private String title;
    private String description;
    private Date creationTime;
    private Iterable<TaskDto> subTasks;
}
