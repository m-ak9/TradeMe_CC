package org.al_cc.TradeMe.use_cases.payment.domain;


import org.al_cc.TradeMe.use_cases.payment.application.command.ProcessPayment;
import org.al_cc.TradeMe.use_cases.user.domain.MemberId;

public interface PaymentService {

    PaymentId process(MemberId memberId, String transactionId, String methodOfPayment, String subscriptionPlan);
}
