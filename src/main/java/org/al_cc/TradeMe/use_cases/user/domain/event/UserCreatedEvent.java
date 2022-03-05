package org.al_cc.TradeMe.use_cases.user.domain.event;

import org.al_cc.TradeMe.use_cases.user.domain.Member;
import org.al_cc.shared_kernel.event.DomainEvent;
import org.al_cc.shared_kernel.event.EventId;

import java.time.ZonedDateTime;

public class UserCreatedEvent implements DomainEvent {
    private final EventId       eventId;
    private final ZonedDateTime occurredDate;
    private final Member        user;

    public UserCreatedEvent(EventId eventId,
                            ZonedDateTime occurredDate,
                            Member user) {
        this.eventId = eventId;
        this.occurredDate = occurredDate;
        this.user = user;
    }

    public static UserCreatedEvent withUser(Member user) {
        return new UserCreatedEvent(EventId.create(), ZonedDateTime.now(), user);
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
}
