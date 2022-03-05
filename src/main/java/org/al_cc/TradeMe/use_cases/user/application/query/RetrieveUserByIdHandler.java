package org.al_cc.TradeMe.use_cases.user.application.query;

import org.al_cc.TradeMe.use_cases.user.domain.Member;
import org.al_cc.TradeMe.use_cases.user.domain.MemberId;
import org.al_cc.TradeMe.use_cases.user.domain.UserRepository;
import org.al_cc.shared_kernel.QueryHandler;

public class RetrieveUserByIdHandler implements QueryHandler<RetrieveUserById, Member> {

    private final UserRepository userRepository;

    public RetrieveUserByIdHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Member handle(RetrieveUserById query) {
        return userRepository.findById(MemberId.of(query.id));
    }
}
