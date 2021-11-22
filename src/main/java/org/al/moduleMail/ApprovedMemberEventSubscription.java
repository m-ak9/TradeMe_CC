package org.al.moduleMail;


import org.al.common.domain.ApprovedMemberEvent;
import org.al.event.Subscriber;

public class ApprovedMemberEventSubscription implements Subscriber<ApprovedMemberEvent> {

    private final MemberMailSender mailSender;

    public ApprovedMemberEventSubscription() {
        this.mailSender = new MemberMailSender();
    }

    @Override
    public void accept(ApprovedMemberEvent event) {
        var member = event.getMember();
        mailSender.sendMail(member);
    }
}
