package org.al_cc.TradeMe.use_cases.user.application.query;

import org.al_cc.TradeMe.use_cases.user.domain.Member;
import org.al_cc.TradeMe.use_cases.user.domain.UserRepository;
import org.al_cc.shared_kernel.QueryHandler;

import java.util.List;

public class RetrieveUsersHandler implements QueryHandler<RetrieveUsers, List<Member>> {

    private final UserRepository userRepository;

    public RetrieveUsersHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<Member> handle(RetrieveUsers query) {
        return userRepository.findAll();
    }
}
