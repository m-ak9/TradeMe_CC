package org.al.infrastructure;

import org.al.common.domain.member.Member;
import org.al.common.domain.member.MemberId;
import org.al.common.domain.member.MemberRepository;
import org.al.common.kernel.Repository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public final class InMemoryMemberRepository implements MemberRepository {
    private final AtomicInteger         counter;
    private final Map<MemberId, Member> data;

    private static final InMemoryMemberRepository INSTANCE = new InMemoryMemberRepository();

    public static InMemoryMemberRepository getInstance() {
        return INSTANCE;
    }

    private InMemoryMemberRepository() {
        this.counter = new AtomicInteger(0);
        this.data = new ConcurrentHashMap<>();
    }

    @Override
    public Member save(Member member) {
        data.put(MemberId.of(counter.incrementAndGet()), member);
        member.addUserId(counter.get());
        return member;
    }

    @Override
    public Member update(Member member) {
        data.put(member.getMemberId(), member);
        return data.get(member.getMemberId());
    }

    @Override
    public Member byId(MemberId memberId) {
        final Member member = data.get(memberId);
        if (member == null) {
            throw new RuntimeException("No member for " + memberId.getValue());
        }
        return member;
    }

    @Override
    public MemberId nextId() {
        return MemberId.of(counter.incrementAndGet());
    }

    @Override
    public List<Member> findAll() {
        return data.values().stream().collect(Collectors.toList());
    }
}
