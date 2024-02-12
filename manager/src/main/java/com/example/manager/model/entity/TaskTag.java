package com.example.manager.model.entity;

import com.example.manager.model.entity.compositeKeys.TaskTagId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "task_tags")
@NoArgsConstructor
@Getter
@IdClass(TaskTagId.class)
public class TaskTag {

    @Id
    @ManyToOne
    @JoinColumn(name = "task_id", foreignKey = @ForeignKey(name = "tsk_tag_fk"))
    private Task task;

    @Id
    @ManyToOne
    @JoinColumn(name = "tag_id", foreignKey = @ForeignKey(name = "tag_grp_fk"))
    private Tag tag;
}
