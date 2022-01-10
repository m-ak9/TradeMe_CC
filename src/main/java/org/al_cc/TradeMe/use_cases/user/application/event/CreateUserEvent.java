package org.al_cc.TradeMe.use_cases.user.application.event;

import org.al_cc.TradeMe.use_cases.payment.application.command.ProcessPayment;
import org.al_cc.TradeMe.use_cases.user.domain.NoUser;
import org.al_cc.TradeMe.use_cases.user.domain.User;
import org.al_cc.shared_kernel.ApplicationEvent;
import org.al_cc.shared_kernel.event.EventId;

import java.time.ZonedDateTime;

public class CreateUserEvent implements ApplicationEvent {
    private final EventId       eventId;
    private final ZonedDateTime occurredDate;
    private final User           user;
    private final ProcessPayment payment;

    public CreateUserEvent(EventId eventId,
                           ZonedDateTime occurredDate,
                           User user,
                           ProcessPayment payment) {
        this.eventId = eventId;
        this.occurredDate = occurredDate;
        this.user = user;
        this.payment = payment;
    }

    public static CreateUserEvent withUser(User user) {
        return new CreateUserEvent(EventId.create(), ZonedDateTime.now(), user, null);
    }

    public static ApplicationEvent withPayment(ProcessPayment payment) {
        return new CreateUserEvent(EventId.create(),ZonedDateTime.now(), new NoUser(), payment);
    }

    @Override
    public EventId getId() {
        return this.eventId;
    }

    @Override
    public ZonedDateTime getOccurredDate() {
        return this.occurredDate;
    }

    public User getUser() {
        return this.user;
    }

    public ProcessPayment getPayment() {
        return this.payment;
    }
}
