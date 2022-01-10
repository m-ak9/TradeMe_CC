package org.al_cc.TradeMe.use_cases.payment.domain;

import java.util.List;

public interface PaymentRepository {

    Payment add(Payment payment);

    Payment update(Payment payment);

    PaymentId nextId();

    List<Payment> findAll();

    Payment findById(PaymentId paymentId);
}
