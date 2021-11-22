package org.al.moduleRegistration.infrastructure;

import org.al.common.domain.member.Member;
import org.al.common.domain.member.MemberId;
import org.al.common.domain.member.MemberRepository;

import java.util.List;

public final class JdbcMemberRepository implements MemberRepository {

    @Override
    public Member save(Member member) {
        throw new UnsupportedOperationException("Not yet implemented.");
    }

    @Override
    public Member update(Member member) {
        throw new UnsupportedOperationException("Not yet implemented.");
    }

    @Override
    public Member byId(MemberId memberId) {
        throw new UnsupportedOperationException("Not yet implemented.");
    }

    @Override
    public MemberId nextId() {
        throw new UnsupportedOperationException("Not yet implemented.");
    }

    @Override
    public List<Member> findAll() {
        throw new UnsupportedOperationException("Not yet implemented.");
    }
}
