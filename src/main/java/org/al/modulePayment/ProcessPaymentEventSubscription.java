package org.al.modulePayment;


import org.al.common.domain.ProcessPaymentEvent;
import org.al.event.Subscriber;
import org.al.modulePayment.domain.PaymentService;

public class ProcessPaymentEventSubscription implements Subscriber<ProcessPaymentEvent> {

    private final PaymentService paymentService;

    public ProcessPaymentEventSubscription() {
        this.paymentService = new PaymentServiceDefault();
    }

    @Override
    public void accept(ProcessPaymentEvent event) {
        var member = event.getMember();
        paymentService.process(member);
    }
}
