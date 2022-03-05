package org.al_cc.TradeMe.use_cases.user.application.query;

import org.al_cc.TradeMe.use_cases.user.domain.Member;
import org.al_cc.TradeMe.use_cases.user.domain.UserRepository;
import org.al_cc.shared_kernel.QueryHandler;

import java.util.List;

public class RetrieveUsersByCityHandler implements QueryHandler<RetrieveUsersByCity, List<Member>> {

    private final UserRepository userRepository;

    public RetrieveUsersByCityHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<Member> handle(RetrieveUsersByCity query) {
        return userRepository.findByCity(query.city);
    }
}
