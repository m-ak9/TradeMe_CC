package org.al_cc.TradeMe.use_cases.payment.domain.event;

import org.al_cc.TradeMe.use_cases.payment.domain.NoPayment;
import org.al_cc.TradeMe.use_cases.payment.domain.Payment;
import org.al_cc.TradeMe.use_cases.user.domain.Member;
import org.al_cc.shared_kernel.event.DomainEvent;
import org.al_cc.shared_kernel.event.EventId;

import java.time.ZonedDateTime;

public class UserSubscriptionConfirmedEvent implements DomainEvent {
    private final EventId       eventId;
    private final ZonedDateTime occurredDate;
    private final Member        user;
    private final Payment       payment;

    public UserSubscriptionConfirmedEvent(EventId eventId,
                                          ZonedDateTime occurredDate,
                                          Member user,
                                          Payment payment) {
        this.eventId = eventId;
        this.occurredDate = occurredDate;
        this.user = user;
        this.payment = payment;
    }

    public static UserSubscriptionConfirmedEvent withUser(Member user) {
        return new UserSubscriptionConfirmedEvent(EventId.create(), ZonedDateTime.now(), user, new NoPayment());
    }

    @Override
    public EventId getId() {
        return this.eventId;
    }

    @Override
    public ZonedDateTime getOccurredDate() {
        return this.occurredDate;
    }

    public Member getUser() {
        return this.user;
    }
    public Payment getPayment() {
        return this.payment;
    }
}
