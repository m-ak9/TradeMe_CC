package org.al_cc.TradeMe.use_cases.user.application.query;

import org.al_cc.shared_kernel.Query;

public class RetrieveUserById implements Query {
    public final int id;

    public RetrieveUserById(int id) {
        this.id = id;
    }
}
