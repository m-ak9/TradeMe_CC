package org.al_cc.TradeMe.use_cases.payment.domain;

public interface PaymentStrategy {
    Payment pay(Payment payment);
}
