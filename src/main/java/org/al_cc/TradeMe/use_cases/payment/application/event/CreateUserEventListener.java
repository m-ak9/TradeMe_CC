package org.al_cc.TradeMe.use_cases.payment.application.event;

import org.al_cc.TradeMe.use_cases.payment.domain.PaymentService;
import org.al_cc.TradeMe.use_cases.user.application.event.CreateUserEvent;
import org.al_cc.shared_kernel.event.EventListener;

public class CreateUserEventListener implements EventListener<CreateUserEvent> {

    private final PaymentService paymentService;


    public CreateUserEventListener(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Override
    public void listenTo(CreateUserEvent event) {
        if (event.getPayment() != null)
            paymentService.process(event.getPayment());
    }
}
