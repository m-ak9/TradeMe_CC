package org.al.modulePayment.domain;

import org.al.common.domain.payment.Payment;
import org.al.common.kernel.Pattern;
import org.al.common.kernel.PaymentException;

import java.util.logging.Logger;

@Pattern
public class TradesmanPaymentStrategy implements PaymentStrategy {
    private static final Logger LOGGER = Logger.getLogger(TradesmanPaymentStrategy.class.getName());

    @Override
    public void pay(Payment payment) {

        if (payment.getCreditCardNumber().isEmpty())
            throw new PaymentException();

        LOGGER.info("Tradesman payment of 15$ successfully executed." + "\n");

    }
}
