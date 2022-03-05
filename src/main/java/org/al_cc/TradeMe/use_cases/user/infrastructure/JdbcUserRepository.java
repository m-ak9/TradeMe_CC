package org.al_cc.TradeMe.use_cases.user.infrastructure;

import org.al_cc.TradeMe.use_cases.user.domain.Member;
import org.al_cc.TradeMe.use_cases.user.domain.MemberId;
import org.al_cc.TradeMe.use_cases.user.domain.UserRepository;

import java.util.List;

public final class JdbcUserRepository implements UserRepository {

    @Override
    public Member add(Member user) {
        throw new UnsupportedOperationException("Not yet implemented.");
    }

    @Override
    public Member update(Member user) {
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

    @Override
    public Member findById(MemberId userId) {
        throw new UnsupportedOperationException("Not yet implemented.");
    }

    @Override
    public List<Member> findByCity(String city) {
        throw new UnsupportedOperationException("Not yet implemented.");
    }
}
