package com.example.manager.model.repository;

import com.example.manager.model.entity.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Long> {

    Project findProjectById(Long id);

    Project findProjectByName(String name);
}
