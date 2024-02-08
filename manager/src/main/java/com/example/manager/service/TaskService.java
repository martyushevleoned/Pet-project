package com.example.manager.service;

import com.example.manager.model.dto.TaskDto;
import com.example.manager.model.entity.Project;
import com.example.manager.model.entity.Task;
import com.example.manager.model.entity.User;
import com.example.manager.model.repository.ProjectRepository;
import com.example.manager.model.repository.TaskRepository;
import com.example.manager.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class TaskService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private TaskRepository taskRepository;

    public Iterable<TaskDto> getTaskDtoByProjectId(Long projectId) {

        Project project = projectRepository.findProjectById(projectId);

        if (project == null)
            return null;

        List<TaskDto> taskDtos = new ArrayList<>();
        project.getTasks().stream().filter(task -> task.getParentTask() == null).forEach(task -> taskDtos.add(taskToTaskDto(task)));
        taskDtos.sort(Comparator.comparing(TaskDto::getCreationTime));

        return taskDtos;
    }

    private TaskDto taskToTaskDto(Task task) {

        List<TaskDto> subTaskDto = new ArrayList<>();
        task.getSubTasks().forEach(t -> {
            subTaskDto.add(taskToTaskDto(t));
        });
        subTaskDto.sort(Comparator.comparing(TaskDto::getCreationTime));

        return new TaskDto(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getCreationTime(),
                subTaskDto
        );
    }
}
