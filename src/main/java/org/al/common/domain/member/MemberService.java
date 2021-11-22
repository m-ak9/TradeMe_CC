package org.al.common.domain.member;

import java.util.List;

public interface MemberService {

    Member save(Member member);

    Member update(Member member);

    Member getById(MemberId memberId);

    MemberId getNextId();

    List<Member> getAll();

}
