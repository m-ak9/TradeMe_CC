package org.al_cc.TradeMe.use_cases.user.domain;

import java.util.List;

public interface UserService {

    Member save(Member user);

    Member update(Member user);

    Member getById(MemberId userId);

    MemberId getNextId();

    List<Member> getAll();

}
