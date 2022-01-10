package org.al_cc.TradeMe.use_cases.payment.domain;

import java.time.Period;

public interface SubscriptionPlan {

    SubscriptionType getSubscriptionType();

    Period getPeriod();
}
