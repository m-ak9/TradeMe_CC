package org.al_cc.TradeMe.use_cases.user.application.query;

import org.al_cc.TradeMe.use_cases.user.domain.User;
import org.al_cc.TradeMe.use_cases.user.domain.UserRepository;
import org.al_cc.shared_kernel.QueryHandler;

import java.util.List;

public class RetrieveUsersHandler implements QueryHandler<RetrieveUsers, List<User>> {

    private final UserRepository userRepository;

    public RetrieveUsersHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> handle(RetrieveUsers query) {
        return userRepository.findAll();
    }
}
