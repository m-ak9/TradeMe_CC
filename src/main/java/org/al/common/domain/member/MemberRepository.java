package org.al.common.domain.member;

import java.util.List;

public interface MemberRepository {

    Member save(Member member);

    Member update(Member member);

    Member byId(MemberId memberId);

    MemberId nextId();

    List<Member> findAll();
}