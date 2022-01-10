package org.al_cc.TradeMe.use_cases.payment.application.command;

import org.al_cc.TradeMe.use_cases.payment.domain.PaymentId;
import org.al_cc.TradeMe.use_cases.payment.domain.PaymentService;
import org.al_cc.shared_kernel.CommandHandler;
import org.al_cc.shared_kernel.annotations.Service;

@Service
public class ProcessPaymentCommandHandler implements CommandHandler<ProcessPayment, PaymentId> {

    private final PaymentService paymentService;

    public ProcessPaymentCommandHandler(PaymentService paymentService) {this.paymentService = paymentService;}

    @Override
    public PaymentId handle(ProcessPayment command) {
        return paymentService.process(command);
    }
}
