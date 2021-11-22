package org.al.common.domain;


import org.al.common.domain.member.Member;
import org.al.common.domain.member.MemberId;
import org.al.common.domain.member.NoMember;
import org.al.event.Event;
import org.al.event.EventId;

import java.time.ZonedDateTime;

public class GetMemberEvent implements Event {

    private final EventId       eventId;
    private final ZonedDateTime occurredDate;
    private final Member        member;
    private final MemberId      memberId;

    private GetMemberEvent(EventId eventId, ZonedDateTime occurredDate, Member member, MemberId memberId) {
        this.eventId = eventId;
        this.occurredDate = occurredDate;
        this.member = member;
        this.memberId = memberId;
    }

    public static GetMemberEvent withMember(Member member) {
        return new GetMemberEvent(EventId.create(), ZonedDateTime.now(), member, MemberId.of(0));
    }

    public static GetMemberEvent withMemberId(MemberId memberId) {
        return new GetMemberEvent(EventId.create(), ZonedDateTime.now(), new NoMember(), memberId);
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

    public MemberId getMemberId() {
        return memberId;
    }
}
