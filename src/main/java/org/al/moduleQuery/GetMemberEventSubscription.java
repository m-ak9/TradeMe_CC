package org.al.moduleQuery;


import org.al.common.GetMemberEvent;
import org.al.common.domain.member.MemberService;
import org.al.event.Subscriber;
import org.al.moduleEventBusProvider.EventBusProvider;

import java.util.logging.Logger;

public class GetMemberEventSubscription implements Subscriber<GetMemberEvent> {
    private static final Logger        LOGGER = Logger.getLogger(GetMemberEventSubscription.class.getName());
    private final        MemberService memberService;

    public GetMemberEventSubscription() {
        this.memberService = new MemberServiceFetchOnly();
    }

    @Override
    public void accept(GetMemberEvent event) {
        var memberId = event.getMemberId();
        var member   = memberService.getById(memberId);
        EventBusProvider.getInstance().getEventBus().send(GetMemberEvent.withMember(member));
    }
}
