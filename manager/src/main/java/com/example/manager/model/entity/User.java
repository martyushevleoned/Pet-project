package com.example.manager.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
public class User {

    public User(Long id, String mail, String username, String password) {
        this.id = id;
        this.mail = mail;
        this.username = username;
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "text", unique = true, nullable = false)
    private String mail;

    @Column(columnDefinition = "text", nullable = false)
    private String username;

    @Column(columnDefinition = "text", nullable = false)
    private String password;

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    List<Project> projects = new ArrayList<>();
}
