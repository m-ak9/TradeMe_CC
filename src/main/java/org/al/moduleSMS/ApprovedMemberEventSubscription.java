package org.al.moduleSMS;


import org.al.common.domain.ApprovedMemberEvent;
import org.al.event.Subscriber;

public class ApprovedMemberEventSubscription implements Subscriber<ApprovedMemberEvent> {

    private final SMSSender smsSender;

    public ApprovedMemberEventSubscription() {
        this.smsSender = new SMSSender();
    }

    @Override
    public void accept(ApprovedMemberEvent event) {
        var user = event.getMember();
        smsSender.sendSMS(user);
    }
}
