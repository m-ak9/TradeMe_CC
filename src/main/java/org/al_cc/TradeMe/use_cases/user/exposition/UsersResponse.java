package org.al_cc.TradeMe.use_cases.user.exposition;

import java.util.List;

public class UsersResponse {

    public final List<UserResponse> users;

    public UsersResponse(List<UserResponse> users) {
        this.users = users;
    }
}
