package org.al_cc.TradeMe.use_cases.user.domain.event;

import org.al_cc.TradeMe.use_cases.user.domain.Member;
import org.al_cc.TradeMe.use_cases.user.infrastructure.NotificationsByMail;
import org.al_cc.shared_kernel.event.EventListener;

public class UserCreatedEventListener implements EventListener<UserCreatedEvent> {

    private  final NotificationsByMail notificationsByMail;

    public UserCreatedEventListener(NotificationsByMail notificationsByMail) {
        this.notificationsByMail = notificationsByMail;
    }

    @Override
    public void listenTo(UserCreatedEvent event) {
        Member user = event.getUser();
        notificationsByMail.send(user.getMail(), "You are succesfully registered");
    }
}
