package com.example.manager.model.repository;

import com.example.manager.model.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByEmail(String mail);
    User findByUsername(String username);
}
