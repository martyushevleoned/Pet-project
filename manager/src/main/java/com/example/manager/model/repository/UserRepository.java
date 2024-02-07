package com.example.manager.model.repository;

import com.example.manager.model.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByMail(String mail);

    User findByUsername(String username);
}
