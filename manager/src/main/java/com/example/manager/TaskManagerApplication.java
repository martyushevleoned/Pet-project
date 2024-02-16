package com.example.manager;

import com.example.manager.model.entity.User;
import com.example.manager.model.repository.UserRepository;
import com.example.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskManagerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TaskManagerApplication.class, args);
	}

	@Autowired
	private UserService userService;


	@Override
	public void run(String... args) {
		userService.createNewUser(new User("email", "username", "password"));
	}
}
