package org.al.moduleRegistration;

import org.al.common.domain.member.Member;
import org.al.common.domain.member.MemberId;
import org.al.common.domain.member.MemberRepository;
import org.al.common.domain.member.MemberService;
import org.al.common.kernel.Service;
import org.al.infrastructure.InMemoryMemberRepository;

import java.util.List;

@Service
public class MemberServiceDefault implements MemberService {

    private final MemberRepository memberRepository = InMemoryMemberRepository.getInstance();


    @Override
    public Member save(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public Member update(Member member) {
        return memberRepository.update(member);
    }

    @Override
    public Member getById(MemberId memberId) {
        return memberRepository.byId(memberId);
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
