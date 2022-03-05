package org.al_cc.TradeMe.use_cases.user.application.event;

import org.al_cc.TradeMe.use_cases.user.application.PaymentDTO;
import org.al_cc.TradeMe.use_cases.user.domain.MemberId;
import org.al_cc.shared_kernel.ApplicationEvent;
import org.al_cc.shared_kernel.event.EventId;

import java.time.ZonedDateTime;

public class ProcessPaymentEvent implements ApplicationEvent {
    private final EventId       eventId;
    private final ZonedDateTime occurredDate;
    private final MemberId      memberId;
    private final PaymentDTO    payment;

    public ProcessPaymentEvent(EventId eventId,
                               ZonedDateTime occurredDate,
                               MemberId memberId,
                               PaymentDTO payment) {
        this.eventId = eventId;
        this.occurredDate = occurredDate;
        this.memberId = memberId;
        this.payment = payment;
    }

    public static ProcessPaymentEvent withMember(MemberId memberId) {
        return new ProcessPaymentEvent(EventId.create(), ZonedDateTime.now(), memberId, null);
    }

    public static ApplicationEvent withPayment(MemberId memberId,
                                               PaymentDTO payment) {
        return new ProcessPaymentEvent(EventId.create(), ZonedDateTime.now(), memberId, payment);
    }

    @Override
    public EventId getId() {
        return this.eventId;
    }

    @Override
    public ZonedDateTime getOccurredDate() {
        return this.occurredDate;
    }

    public MemberId getMemberId() {
        return this.memberId;
    }

    public PaymentDTO getPayment() {
        return this.payment;
    }
}
