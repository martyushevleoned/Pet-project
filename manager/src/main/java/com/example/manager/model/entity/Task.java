package com.example.manager.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tasks")
@NoArgsConstructor
@Getter
public class Task {

    public Task(String title, String description, Project project) {
        this.title = title;
        this.description = description;
        this.project = project;
    }

    public Task(String title, String description, Project project, Task parentTask) {
        this.title = title;
        this.description = description;
        this.project = project;
        this.parentTask = parentTask;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "text", nullable = false)
    private String title;

    @Column(columnDefinition = "text")
    private String description;

    @Column(columnDefinition = "timestamp default current_timestamp", nullable = false)
    private Date creationTime;

    @OneToMany(mappedBy = "parentTask", orphanRemoval = true)
    List<Task> tasks = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "project_id", foreignKey = @ForeignKey(name = "prj_tsk_fk"), nullable = false)
    private Project project;

    @ManyToOne
    @JoinColumn(name = "parent_task_id", foreignKey = @ForeignKey(name = "tsk_prt_tsk_fk"))
    private Task parentTask;

}
