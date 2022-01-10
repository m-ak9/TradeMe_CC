package org.al_cc.TradeMe.use_cases.user.domain;

import java.util.List;

public interface UserService {

    User save(User user);

    User update(User user);

    User getById(UserId userId);

    UserId getNextId();

    List<User> getAll();

}
