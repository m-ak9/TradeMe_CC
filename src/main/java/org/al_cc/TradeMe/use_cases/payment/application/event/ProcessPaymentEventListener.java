package org.al_cc.TradeMe.use_cases.payment.application.event;

import org.al_cc.TradeMe.use_cases.payment.domain.PaymentService;
import org.al_cc.TradeMe.use_cases.user.application.event.ProcessPaymentEvent;
import org.al_cc.shared_kernel.event.EventListener;

public class ProcessPaymentEventListener implements EventListener<ProcessPaymentEvent> {

    private final PaymentService paymentService;


    public ProcessPaymentEventListener(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Override
    public void listenTo(ProcessPaymentEvent event) {
        if (event.getPayment() != null)
            paymentService.process(event.getMemberId(), event.getPayment().transactionId, event.getPayment().methodOfPayment, event.getPayment().subscriptionPlan);
    }
}
