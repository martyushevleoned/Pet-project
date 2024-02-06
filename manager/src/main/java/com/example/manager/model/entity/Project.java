package com.example.manager.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "projects")
@NoArgsConstructor
@Getter
public class Project {

    public Project(String name, User user) {
        this.name = name;
        this.user = user;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "text", nullable = false)
    private String name;

    @Column(columnDefinition = "timestamp default current_timestamp", nullable = false)
    private Date creationTime;

    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "usr_prj_fk"), nullable = false)
    private User user;

    @OneToMany(mappedBy = "project", orphanRemoval = true)
    List<Task> tasks = new ArrayList<>();
}
