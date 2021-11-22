package org.al.modulePayment;

import org.al.common.domain.ApprovedMemberEvent;
import org.al.common.domain.member.Member;
import org.al.common.kernel.PaymentException;
import org.al.common.kernel.Service;
import org.al.moduleEventBusProvider.EventBusProvider;
import org.al.modulePayment.domain.PaymentService;
import org.al.modulePayment.domain.PaymentStrategy;
import org.al.modulePayment.domain.PaymentStrategyFactory;

import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class PaymentServiceDefault implements PaymentService {
    private static final Logger LOGGER = Logger.getLogger(PaymentServiceDefault.class.getName());

    @Override
    public void process(Member member) {
        LOGGER.info("Payment started for : " + member.toString() + "\n");

        PaymentStrategy paymentStrategy = PaymentStrategyFactory.getStrategy(member);

        try {
            paymentStrategy.pay(member.getPayment());
        } catch (PaymentException e) {
            LOGGER.log(Level.SEVERE, String.valueOf(e));
        }

        EventBusProvider.getInstance().getEventBus().send(ApprovedMemberEvent.withMember(member));
    }
}
