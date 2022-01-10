package org.al_cc.TradeMe.use_cases.payment.domain;

import java.time.LocalDate;
import java.time.Period;

public class YearlySubscriptionPlan implements SubscriptionPlan {

    SubscriptionType subscriptionType;
    Period           period;

    public YearlySubscriptionPlan() {
        this.subscriptionType = SubscriptionType.YEARLY;
        this.period = Period.between(LocalDate.now(), LocalDate.now().plusYears(1));
    }

    @Override
    public SubscriptionType getSubscriptionType() {
        return this.subscriptionType;
    }

    @Override
    public Period getPeriod() {
        return this.period;
    }

}
