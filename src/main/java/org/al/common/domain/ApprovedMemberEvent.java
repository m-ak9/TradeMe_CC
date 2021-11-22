package org.al.common.domain;


import org.al.common.domain.member.Member;
import org.al.event.Event;
import org.al.event.EventId;

import java.time.ZonedDateTime;

public class ApprovedMemberEvent implements Event {

    private final EventId       eventId;
    private final ZonedDateTime occurredDate;
    private final Member        member;

    private ApprovedMemberEvent(EventId eventId, ZonedDateTime occurredDate, Member member) {
        this.eventId = eventId;
        this.occurredDate = occurredDate;
        this.member = member;
    }

    public static ApprovedMemberEvent withMember(Member member) {
        return new ApprovedMemberEvent(EventId.create(), ZonedDateTime.now(), member);
    }

    @Override
    public EventId getId() {
        return eventId;
    }

    @Override
    public ZonedDateTime getOccurredDate() {
        return occurredDate;
    }

    public EventId getEventId() {
        return eventId;
    }

    public Member getMember() {
        return member;
    }
}
