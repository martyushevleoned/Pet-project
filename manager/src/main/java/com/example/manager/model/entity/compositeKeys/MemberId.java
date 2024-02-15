package com.example.manager.model.entity.compositeKeys;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MemberId implements Serializable {

    private Long user;

    private Long project;

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof MemberId memberId))
            return false;
        return project.equals(memberId.getProject()) && user.equals(memberId.getUser());
    }

    @Override
    public int hashCode() {
        return (int) (17 * project + 31 * user);
    }
}
