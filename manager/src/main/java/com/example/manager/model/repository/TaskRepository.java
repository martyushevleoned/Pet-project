package com.example.manager.model.repository;

import com.example.manager.model.entity.Task;
import org.springframework.data.repository.Repository;

public interface TaskRepository extends Repository<Task, Long> {
}
