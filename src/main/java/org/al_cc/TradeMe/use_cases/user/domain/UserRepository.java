package org.al_cc.TradeMe.use_cases.user.domain;

import java.util.List;

public interface UserRepository {

    User add(User user);

    User update(User user);

    UserId nextId();

    List<User> findAll();

    User findById(UserId userId);

    List<User> findByCity(String city);
}
