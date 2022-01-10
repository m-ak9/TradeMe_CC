package org.al_cc.TradeMe.use_cases.payment.domain;

import org.al_cc.TradeMe.use_cases.user.domain.UserId;

public final class DefaultPayment implements Payment {


    private final TransactionId                                        transactionId;
    private final UserId                                               userId;
    private       org.al_cc.TradeMe.use_cases.payment.domain.PaymentId paymentId;
    private final MethodOfPaymentType                                  methodOfPaymentType;
    private final SubscriptionPlan    subscriptionPlan;
    private final Price               price;
    private boolean             done;

    public DefaultPayment(TransactionId transactionId,
                          UserId userId,
                          org.al_cc.TradeMe.use_cases.payment.domain.PaymentId paymentId,
                          MethodOfPaymentType methodOfPaymentType,
                          SubscriptionPlan subscriptionPlan,
                          Price price,
                          boolean done) {
        this.transactionId = transactionId;
        this.userId = userId;
        this.paymentId = paymentId;
        this.methodOfPaymentType = methodOfPaymentType;
        this.subscriptionPlan = subscriptionPlan;
        this.price = price;
        this.done = done;
    }

    public static DefaultPayment of(TransactionId transactionId,
                                    UserId userId,
                                    org.al_cc.TradeMe.use_cases.payment.domain.PaymentId paymentId,
                                    MethodOfPaymentType methodOfPaymentType,
                                    SubscriptionPlan subscriptionPlan,
                                    Price price,
                                    boolean done) {
        return new DefaultPayment(transactionId, userId, paymentId, methodOfPaymentType, subscriptionPlan, price, done);
    }

    @Override
    public TransactionId getTransactionId() {
        return this.transactionId;
    }

    @Override
    public UserId getUserId() {
        return this.userId;
    }

    @Override
    public PaymentId getPaymentId() {
        return this.paymentId;
    }

    @Override public void addPaymentId(int paymentId) {
        this.paymentId = new PaymentId(paymentId);
    }

    @Override
    public MethodOfPaymentType getMethodOfPayment() {
        return this.methodOfPaymentType;
    }

    @Override
    public SubscriptionPlan getSubscriptionPlan() {
        return this.subscriptionPlan;
    }

    @Override
    public Price getPrice() {
        return this.price;
    }

    @Override
    public void done() {
        this.done = true;
    }

    @Override
    public boolean isDone() {
        return this.done;
    }
}
