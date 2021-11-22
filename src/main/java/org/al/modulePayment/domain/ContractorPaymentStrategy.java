package org.al.modulePayment.domain;

import org.al.common.domain.payment.Payment;
import org.al.common.kernel.PaymentException;

import java.util.logging.Logger;

public class ContractorPaymentStrategy implements PaymentStrategy {
    private static final Logger LOGGER = Logger.getLogger(ContractorPaymentStrategy.class.getName());

    @Override
    public void pay(Payment payment) {

        if (payment.getCreditCardNumber().isEmpty())
            throw new PaymentException();

        LOGGER.info("Contractor payment of 30$ successfully executed." + "\n");
    }
}
