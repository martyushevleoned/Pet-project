package com.example.manager.model.repository;

import com.example.manager.model.entity.GroupOfTags;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupOfTagsRepository extends CrudRepository<GroupOfTags, Long> {
}
