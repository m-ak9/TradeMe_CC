package org.al_cc.TradeMe.use_cases.payment.domain;

import org.al_cc.shared_kernel.annotations.Pattern;
import org.al_cc.shared_kernel.exceptions.NotValidAttributeException;

@Pattern
public final class SubscriptionPlanFactory {

    private SubscriptionPlanFactory() {
        throw new AssertionError();
    }

    public static SubscriptionPlan create(SubscriptionType subscriptionType) {
        if (subscriptionType.equals(SubscriptionType.MONTHLY))
            return new MonthlySubscriptionPlan();
        if (subscriptionType.equals(SubscriptionType.YEARLY))
            return new YearlySubscriptionPlan();
        throw new NotValidAttributeException("No subscription corresponding to the given plan.");
    }

}
