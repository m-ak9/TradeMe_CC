package org.al.modulePayment.domain;

import org.al.common.domain.payment.Payment;

public interface PaymentStrategy {

    void pay(Payment payment);
}
