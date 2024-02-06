package com.example.manager.model.repository;

import com.example.manager.model.entity.User;
import org.springframework.data.repository.Repository;

public interface UserRepository extends Repository<User, Long> {
}
