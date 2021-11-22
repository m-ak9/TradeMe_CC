package org.al.moduleNotifier;


import org.al.common.GetMemberEvent;
import org.al.common.domain.member.DefaultMember;
import org.al.event.Subscriber;

import java.util.logging.Logger;

public class GetMemberEventSubscription implements Subscriber<GetMemberEvent> {
    private static final Logger             LOGGER = Logger.getLogger(GetMemberEventSubscription.class.getName());
    private final        NotificationSender notificationSender;

    public GetMemberEventSubscription() {
        this.notificationSender = new NotificationSender();
    }


    @Override
    public void accept(GetMemberEvent event) {
        if (event.getMember() instanceof DefaultMember) {
            var member = event.getMember();
            notificationSender.foundMember(member);
        }
    }
}
