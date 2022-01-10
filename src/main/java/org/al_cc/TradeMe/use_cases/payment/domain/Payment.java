package org.al_cc.TradeMe.use_cases.payment.domain;

import org.al_cc.TradeMe.use_cases.user.domain.UserId;

public interface Payment {

    TransactionId getTransactionId();

    UserId getUserId();

    PaymentId getPaymentId();

    void addPaymentId(int paymentId);

    MethodOfPaymentType getMethodOfPayment();

    SubscriptionPlan getSubscriptionPlan();

    Price getPrice();

    void done();

    boolean isDone();





}
