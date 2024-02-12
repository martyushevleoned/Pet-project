package com.example.manager.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tags")
@NoArgsConstructor
@Getter
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "text", nullable = false)
    private String name;

    @Column(columnDefinition = "bigint", nullable = false)
    private Long tagOrder;

    @ManyToOne
    @JoinColumn(name = "group_of_tags_id", foreignKey = @ForeignKey(name = "grp_tag_fk"), nullable = false)
    private GroupOfTags groupOfTags;


}
