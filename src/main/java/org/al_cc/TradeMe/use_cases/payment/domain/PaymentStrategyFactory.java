package org.al_cc.TradeMe.use_cases.payment.domain;

import org.al_cc.shared_kernel.annotations.Pattern;
import org.al_cc.shared_kernel.exceptions.NotValidAttributeException;

@Pattern
public final class PaymentStrategyFactory {

    private PaymentStrategyFactory() {
        throw new AssertionError();
    }

    public static PaymentStrategy getStrategy(MethodOfPaymentType methodOfPaymentType) {
        if (methodOfPaymentType.equals(MethodOfPaymentType.PAYPAL))
            return new PaypalPaymentStrategy();
        if (methodOfPaymentType.equals(MethodOfPaymentType.CREDITCARD))
            return new CreditCardPaymentStrategy();
        throw new NotValidAttributeException("Unsupported method of payment.");
    }

}
