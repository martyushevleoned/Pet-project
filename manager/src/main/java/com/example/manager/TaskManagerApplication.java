package com.example.manager;

import com.example.manager.model.entity.Project;
import com.example.manager.model.entity.Task;
import com.example.manager.model.entity.User;
import com.example.manager.model.repository.ProjectRepository;
import com.example.manager.model.repository.TaskRepository;
import com.example.manager.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class TaskManagerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TaskManagerApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private TaskRepository taskRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;


	@Override
	public void run(String... args) {

		userRepository.save(new User("123", "username", passwordEncoder.encode("123")));

		projectRepository.save(new Project("project1", userRepository.findByMail("123")));
		projectRepository.save(new Project("project2", userRepository.findByMail("123")));

		taskRepository.save(new Task("main task1", "", projectRepository.findProjectByName("project1")));
		taskRepository.save(new Task("main task2", "", projectRepository.findProjectByName("project1")));

		taskRepository.save(new Task("sub task1", "", projectRepository.findProjectByName("project1"), taskRepository.findTaskByTitle("main task1")));
		taskRepository.save(new Task("sub task2", "", projectRepository.findProjectByName("project1"), taskRepository.findTaskByTitle("main task1")));
	}
}
