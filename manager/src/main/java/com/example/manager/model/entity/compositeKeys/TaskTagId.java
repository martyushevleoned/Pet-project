package com.example.manager.model.entity.compositeKeys;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class TaskTagId implements Serializable {

    private Long task;

    private Long tag;

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof TaskTagId taskTagId))
            return false;
        return task.equals(taskTagId.getTask()) && tag.equals(taskTagId.getTag());
    }

    @Override
    public int hashCode() {
        return (int) (17 * task + 31 * tag);
    }
}
