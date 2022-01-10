package org.al_cc.TradeMe.use_cases.payment.domain;


import org.al_cc.TradeMe.use_cases.payment.application.command.ProcessPayment;

public interface PaymentService {
    PaymentId process(ProcessPayment user);
}
