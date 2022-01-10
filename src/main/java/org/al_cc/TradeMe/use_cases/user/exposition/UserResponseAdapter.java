package org.al_cc.TradeMe.use_cases.user.exposition;

import org.al_cc.TradeMe.use_cases.user.domain.User;
import org.al_cc.shared_kernel.Adapter;

public class UserResponseAdapter implements Adapter<User, UserResponse> {

    @Override
    public UserResponse adapt(User source) {
        return new UserResponse(
                String.valueOf(source.getUserId().getValue()),
                source.getLastname(),
                source.getFirstname(),
                source.getLogin(),
                source.getUserType().toString(),
                source.getMail(),
                new AddressResponse(
                        source.getAddress().city(),
                        source.getAddress().country(),
                        source.getAddress().street(),
                        source.getAddress().zipCode()
                ));
    }
}
