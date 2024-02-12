package com.example.manager;

import com.example.manager.model.dto.TaskDto;
import com.example.manager.model.entity.Project;
import com.example.manager.model.entity.Task;
import com.example.manager.model.entity.User;
import com.example.manager.model.repository.ProjectRepository;
import com.example.manager.model.repository.TaskRepository;
import com.example.manager.model.repository.UserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Before
    public void setUp() {
        userRepository.save(new User("mail", "username", "password"));

        projectRepository.save(new Project("project1", userRepository.findByEmail("mail")));
        projectRepository.save(new Project("project2", userRepository.findByEmail("mail")));

        taskRepository.save(new Task("main task1", "", projectRepository.findProjectByName("project1")));
        taskRepository.save(new Task("main task2", "", projectRepository.findProjectByName("project1")));

        taskRepository.save(new Task("sub task1", "", projectRepository.findProjectByName("project1"), taskRepository.findTaskByTitle("main task1")));
    }

    @Test
    public void name() {
        User user = userRepository.findByEmail("mail");
        System.out.println(user.getId());

        Project project = projectRepository.findProjectByName("project1");
        System.out.println(project.getName());

        project.getTasks().forEach(t -> {
            System.out.println(taskToTaskDto(t));
        });
    }

    private TaskDto taskToTaskDto(Task task) {

        List<TaskDto> subTaskDto = new ArrayList<>();
        task.getSubTasks().forEach(t -> {
            subTaskDto.add(taskToTaskDto(t));
        });

        return new TaskDto(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getCreationTime(),
                subTaskDto
        );
    }

    @After
    public void tearDown() {
        userRepository.deleteAll();
    }
}
