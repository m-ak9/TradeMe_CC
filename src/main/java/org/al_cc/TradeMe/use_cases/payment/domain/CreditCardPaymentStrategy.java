package org.al_cc.TradeMe.use_cases.payment.domain;

import org.al_cc.shared_kernel.annotations.Pattern;
import org.al_cc.shared_kernel.exceptions.PaymentException;

import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

@Pattern
public class CreditCardPaymentStrategy implements PaymentStrategy {
    private static final Logger LOGGER = Logger.getLogger(CreditCardPaymentStrategy.class.getName());

    @Override
    public Payment pay(Payment payment) {

        LOGGER.info("Waiting for confirmation from Stripe for transactionId : " + payment.getTransactionId() + "\n");

        if (Objects.isNull(payment.getTransactionId()))
            throw new PaymentException("Payment with Stripe failure");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        payment.done();

        return payment;
    }
}
