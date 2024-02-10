package com.example.manager.controller;

import com.example.manager.model.dto.TaskDto;
import com.example.manager.model.entity.User;
import com.example.manager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DefaultController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/profile")
    @ResponseBody
    private ResponseEntity<Iterable<TaskDto>> getSomeTest(@AuthenticationPrincipal User user){
        System.out.println(user.getEmail());
        System.out.println(user.getUsername());
        return ResponseEntity.status(HttpStatus.OK).body(taskService.getTaskDtoByProjectId(1L));
    }
}
