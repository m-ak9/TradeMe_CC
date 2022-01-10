package org.al_cc.TradeMe.use_cases.user.application.query;

import org.al_cc.TradeMe.use_cases.user.domain.User;
import org.al_cc.TradeMe.use_cases.user.domain.UserId;
import org.al_cc.TradeMe.use_cases.user.domain.UserRepository;
import org.al_cc.shared_kernel.QueryHandler;

public class RetrieveUserByIdHandler implements QueryHandler<RetrieveUserById, User> {

    private final UserRepository userRepository;

    public RetrieveUserByIdHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User handle(RetrieveUserById query) {
        return userRepository.findById(UserId.of(query.id));
    }
}
