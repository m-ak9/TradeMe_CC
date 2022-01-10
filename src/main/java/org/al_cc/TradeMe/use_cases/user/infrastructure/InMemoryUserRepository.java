package org.al_cc.TradeMe.use_cases.user.infrastructure;

import org.al_cc.TradeMe.use_cases.user.domain.User;
import org.al_cc.TradeMe.use_cases.user.domain.UserId;
import org.al_cc.TradeMe.use_cases.user.domain.UserRepository;
import org.al_cc.shared_kernel.exceptions.NoSuchEntityException;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public final class InMemoryUserRepository implements UserRepository {
    private final AtomicInteger     counter;
    private final Map<UserId, User> data;

    private static final InMemoryUserRepository INSTANCE = new InMemoryUserRepository();

    public static InMemoryUserRepository getInstance() {
        return INSTANCE;
    }

    public InMemoryUserRepository() {
        this.counter = new AtomicInteger(0);

        this.data = new ConcurrentHashMap<>();
    }

    @Override
    public User add(User user) {
        data.put(user.getUserId(), user);
        user.addUserId(counter.get());
        return user;
    }

    @Override
    public User update(User user) {
        data.put(user.getUserId(), user);
        return data.get(user.getUserId());
    }


    @Override
    public UserId nextId() {
        return UserId.of(counter.incrementAndGet());
    }

    @Override
    public List<User> findAll() {
        return data.values().stream().collect(Collectors.toList());
    }

    @Override public User findById(UserId userId) {
        final User user = data.get(userId);
        if (user == null) {
            throw new NoSuchEntityException("No member for " + userId.getValue());
        }
        return user;
    }

    @Override
    public List<User> findByCity(String city) {
        List<User> users = data.values()
                               .stream()
                               .filter(user -> user.getAddress().city().equalsIgnoreCase(city))
                               .collect(Collectors.toList());
        if (users.isEmpty()) {
            throw new NoSuchEntityException("no members for the city " + city);
        }
        return users;
    }
}
