package org.al_cc.TradeMe.use_cases.user.infrastructure;

import org.al_cc.TradeMe.use_cases.user.domain.User;
import org.al_cc.TradeMe.use_cases.user.domain.UserId;
import org.al_cc.TradeMe.use_cases.user.domain.UserRepository;

import java.util.List;

public final class JdbcUserRepository implements UserRepository {

    @Override
    public User add(User user) {
        throw new UnsupportedOperationException("Not yet implemented.");
    }

    @Override
    public User update(User user) {
        throw new UnsupportedOperationException("Not yet implemented.");
    }

    @Override
    public UserId nextId() {
        throw new UnsupportedOperationException("Not yet implemented.");
    }

    @Override
    public List<User> findAll() {
        throw new UnsupportedOperationException("Not yet implemented.");
    }

    @Override
    public User findById(UserId userId) {
        throw new UnsupportedOperationException("Not yet implemented.");
    }

    @Override
    public List<User> findByCity(String city) {
        throw new UnsupportedOperationException("Not yet implemented.");
    }
}
