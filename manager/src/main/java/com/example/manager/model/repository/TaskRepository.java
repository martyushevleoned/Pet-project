package com.example.manager.model.repository;

import com.example.manager.model.entity.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {

    Task findTaskByTitle(String title);
}
