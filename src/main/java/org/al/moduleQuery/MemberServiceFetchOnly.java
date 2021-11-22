package org.al.moduleQuery;

import org.al.common.domain.member.Member;
import org.al.common.domain.member.MemberId;
import org.al.common.domain.member.MemberRepository;
import org.al.common.domain.member.MemberService;
import org.al.infrastructure.InMemoryMemberRepository;

import java.util.List;
import java.util.logging.Logger;

public class MemberServiceFetchOnly implements MemberService {
    private static final Logger LOGGER = Logger.getLogger(MemberServiceFetchOnly.class.getName());

    private final MemberRepository memberRepository = InMemoryMemberRepository.getInstance();


    @Override
    public Member save(Member member) {
        throw new UnsupportedOperationException("This service is fetch only.");
    }

    @Override
    public Member update(Member member) {
        throw new UnsupportedOperationException("This service is fetch only.");
    }

    @Override
    public Member getById(MemberId memberId) {

        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public MemberId getNextId() {
        return memberRepository.nextId();
    }

    @Override
    public List<Member> getAll() {
        return memberRepository.findAll();
    }
}
