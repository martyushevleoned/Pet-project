package com.example.manager.model.repository;

import com.example.manager.model.entity.TaskTag;
import com.example.manager.model.entity.compositeKeys.TaskTagId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskTagRepository extends CrudRepository<TaskTag, TaskTagId> {
}
