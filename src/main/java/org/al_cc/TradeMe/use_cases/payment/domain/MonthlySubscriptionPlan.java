package org.al_cc.TradeMe.use_cases.payment.domain;

import java.time.LocalDate;
import java.time.Period;

public class MonthlySubscriptionPlan implements SubscriptionPlan {

    SubscriptionType subscriptionType;
    Period           period;

    public MonthlySubscriptionPlan() {
        this.subscriptionType = SubscriptionType.MONTHLY;
        this.period = Period.between(LocalDate.now(), LocalDate.now().plusMonths(1));
    }

    @Override public SubscriptionType getSubscriptionType() {
        return this.subscriptionType;
    }

    @Override public Period getPeriod() {
        return this.period;
    }
}
