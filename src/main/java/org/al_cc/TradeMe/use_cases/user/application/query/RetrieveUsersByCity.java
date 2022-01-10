package org.al_cc.TradeMe.use_cases.user.application.query;

import org.al_cc.shared_kernel.Query;

public class RetrieveUsersByCity implements Query {
    public final String city;

    public RetrieveUsersByCity(String city) {
        this.city = city;
    }
}
