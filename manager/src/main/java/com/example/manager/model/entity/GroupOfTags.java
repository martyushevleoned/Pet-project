package com.example.manager.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "group_of_tags")
@NoArgsConstructor
@Getter
public class GroupOfTags {

    public GroupOfTags(String name, Project project) {
        this.name = name;
        this.project = project;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "text", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "project_id", foreignKey = @ForeignKey(name = "prj_grp_tsk_fk"), nullable = false)
    private Project project;

    @OneToMany(mappedBy = "groupOfTags", orphanRemoval = true, fetch = FetchType.EAGER)
    List<Tag> tags = new ArrayList<>();

}
