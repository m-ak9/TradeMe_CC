package org.al.modulePayment.domain;

import org.al.common.domain.payment.Payment;
import org.al.common.kernel.Pattern;

public interface PaymentStrategy {

    void pay(Payment payment);
}
