package org.al_cc.TradeMe.use_cases.user.domain.event;

import org.al_cc.TradeMe.use_cases.user.domain.User;
import org.al_cc.shared_kernel.event.DomainEvent;
import org.al_cc.shared_kernel.event.EventId;

import java.time.ZonedDateTime;

public class UserRegistrationConfirmedEvent implements DomainEvent {
    private final EventId       eventId;
    private final ZonedDateTime occurredDate;
    private final User          user;

    public UserRegistrationConfirmedEvent(EventId eventId,
                                          ZonedDateTime occurredDate,
                                          User user) {
        this.eventId = eventId;
        this.occurredDate = occurredDate;
        this.user = user;
    }

    public static UserRegistrationConfirmedEvent withUser(User user) {
        return new UserRegistrationConfirmedEvent(EventId.create(), ZonedDateTime.now(), user);
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
}
