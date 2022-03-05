package org.al_cc.TradeMe.use_cases.user.infrastructure;

import org.al_cc.TradeMe.use_cases.user.domain.Member;
import org.al_cc.TradeMe.use_cases.user.domain.MemberId;
import org.al_cc.TradeMe.use_cases.user.domain.UserRepository;
import org.al_cc.shared_kernel.exceptions.NoSuchEntityException;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public final class InMemoryUserRepository implements UserRepository {
    private final AtomicInteger         counter;
    private final Map<MemberId, Member> data;

    private static final InMemoryUserRepository INSTANCE = new InMemoryUserRepository();

    public static InMemoryUserRepository getInstance() {
        return INSTANCE;
    }

    public InMemoryUserRepository() {
        this.counter = new AtomicInteger(0);

        this.data = new ConcurrentHashMap<>();
    }

    @Override
    public Member add(Member user) {
        data.put(user.getUserId(), user);
        user.addUserId(counter.get());
        return user;
    }

    @Override
    public Member update(Member user) {
        data.put(user.getUserId(), user);
        return data.get(user.getUserId());
    }


    @Override
    public MemberId nextId() {
        return MemberId.of(counter.incrementAndGet());
    }

    @Override
    public List<Member> findAll() {
        return data.values().stream().collect(Collectors.toList());
    }

    @Override public Member findById(MemberId userId) {
        final Member user = data.get(userId);
        if (user == null) {
            throw new NoSuchEntityException("No member for " + userId.getValue());
        }
        return user;
    }

    @Override
    public List<Member> findByCity(String city) {
        List<Member> users = data.values()
                                 .stream()
                                 .filter(user -> user.getAddress().city().equalsIgnoreCase(city))
                                 .collect(Collectors.toList());
        if (users.isEmpty()) {
            throw new NoSuchEntityException("no members for the city " + city);
        }
        return users;
    }
}
