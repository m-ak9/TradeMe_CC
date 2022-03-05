package org.al_cc.TradeMe.use_cases.user.domain;

import java.util.List;

public interface UserRepository {

    Member add(Member user);

    Member update(Member user);

    MemberId nextId();

    List<Member> findAll();

    Member findById(MemberId userId);

    List<Member> findByCity(String city);
}
