package org.al_cc.TradeMe.use_cases.payment.domain;

import org.al_cc.TradeMe.use_cases.user.domain.MemberId;

public class NoPayment implements Payment {
    @Override public TransactionId getTransactionId() {
        throw new UnsupportedOperationException();
    }

    @Override public MemberId getUserId() {
        throw new UnsupportedOperationException();
    }

    @Override public PaymentId getPaymentId() {
        throw new UnsupportedOperationException();
    }

    @Override public void addPaymentId(int paymentId) {
        throw new UnsupportedOperationException();
    }

    @Override public MethodOfPaymentType getMethodOfPayment() {
        throw new UnsupportedOperationException();
    }

    @Override public SubscriptionPlan getSubscriptionPlan() {
        throw new UnsupportedOperationException();
    }

    @Override public Price getPrice() {
        throw new UnsupportedOperationException();
    }

    @Override public void done() {
        throw new UnsupportedOperationException();
    }

    @Override public boolean isDone() {
        throw new UnsupportedOperationException();
    }
}
