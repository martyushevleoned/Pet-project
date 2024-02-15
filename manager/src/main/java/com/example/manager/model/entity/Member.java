package com.example.manager.model.entity;

import com.example.manager.model.entity.compositeKeys.MemberId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "members")
@NoArgsConstructor
@Getter
@IdClass(MemberId.class)
public class Member {

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "usr_mbr_fk"))
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "project_id", foreignKey = @ForeignKey(name = "mbr_prj_fk"))
    private Project project;
}
