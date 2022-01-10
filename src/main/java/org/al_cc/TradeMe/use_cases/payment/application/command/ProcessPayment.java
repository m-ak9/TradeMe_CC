package org.al_cc.TradeMe.use_cases.payment.application.command;

import org.al_cc.TradeMe.use_cases.user.domain.UserId;
import org.al_cc.shared_kernel.Command;

/**
 * Command object
 */
@SuppressWarnings("all")
public final class ProcessPayment implements Command {

    public String methodOfPayment;

    public String subscriptionPlan;

    public String transactionId;

    public UserId userId;

    public ProcessPayment(String methodOfPayment,
                          String subscriptionPlan,
                          String transactionId,
                          UserId userId) {
        this.methodOfPayment = methodOfPayment;
        this.subscriptionPlan = subscriptionPlan;
        this.transactionId = transactionId;
        this.userId = userId;
    }
}
