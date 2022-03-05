package org.al_cc.TradeMe.use_cases.payment.application.service;

import org.al_cc.TradeMe.use_cases.payment.domain.*;
import org.al_cc.TradeMe.use_cases.payment.domain.event.UserSubscriptionConfirmedEvent;
import org.al_cc.TradeMe.use_cases.user.domain.Member;
import org.al_cc.TradeMe.use_cases.user.domain.MemberId;
import org.al_cc.TradeMe.use_cases.user.domain.UserRepository;
import org.al_cc.shared_kernel.annotations.Service;
import org.al_cc.shared_kernel.event.DomainEvent;
import org.al_cc.shared_kernel.event.EventDispatcher;
import org.al_cc.shared_kernel.event.EventId;

import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.logging.Logger;

@Service
public class PaymentServiceDefault implements PaymentService {
    private static final Logger LOGGER = Logger.getLogger(PaymentServiceDefault.class.getName());

    private final PaymentRepository            paymentRepository;
    private final UserRepository               userRepository;
    private final EventDispatcher<DomainEvent> domainEventDispatcher;

    public PaymentServiceDefault(PaymentRepository paymentRepository, UserRepository userRepository, EventDispatcher<DomainEvent> domainEventDispatcher) {
        this.userRepository = userRepository;
        this.paymentRepository = paymentRepository;
        this.domainEventDispatcher = domainEventDispatcher;
    }

    @Override
    public PaymentId process(MemberId memberId, String transactionId, String methodOfPayment, String subscriptionPlan) {
        Member    user      = this.userRepository.findById(memberId);
        PaymentId paymentId = this.paymentRepository.nextId();
        Price     price     = EuroPrice.of(10);         //Fake retrieve price from database
        Payment paymentToProceed = DefaultPayment.of(
                TransactionId.of(transactionId),
                memberId,
                paymentId,
                MethodOfPaymentType.fromString(methodOfPayment),
                SubscriptionPlanFactory.create(Objects.requireNonNull(SubscriptionType.fromString(subscriptionPlan))),
                price,
                false
        );

        LOGGER.info("Payment started for : " + user.getLogin() + ", type= " + user.getUserType().toString() + "\n");

        PaymentStrategy paymentStrategy = PaymentStrategyFactory.getStrategy(
                Objects.requireNonNull(MethodOfPaymentType.fromString(methodOfPayment))
        );
        Payment payment = paymentStrategy.pay(paymentToProceed);
        var paymentResult = this.paymentRepository.add(payment);

        domainEventDispatcher.dispatch(new UserSubscriptionConfirmedEvent(EventId.create(), ZonedDateTime.now(), user, payment));

        return paymentResult.getPaymentId();
    }
}
