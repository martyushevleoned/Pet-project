package com.example.manager.model.repository;

import com.example.manager.model.entity.Member;
import com.example.manager.model.entity.compositeKeys.MemberId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends CrudRepository<Member, MemberId> {
}
