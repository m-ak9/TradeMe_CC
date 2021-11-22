package org.al.moduleQuery.infrastructure;

import org.al.common.domain.member.Member;
import org.al.common.domain.member.MemberId;
import org.al.common.domain.member.MemberRepository;
import org.al.common.kernel.Repository;

import java.util.List;

@Repository
public final class JdbcMemberFetchOnlyRepository implements MemberRepository {

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
