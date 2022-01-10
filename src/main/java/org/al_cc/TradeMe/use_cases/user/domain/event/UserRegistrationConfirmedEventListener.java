package org.al_cc.TradeMe.use_cases.user.domain.event;

import org.al_cc.TradeMe.use_cases.user.domain.User;
import org.al_cc.TradeMe.use_cases.user.infrastructure.NotificationsByMail;
import org.al_cc.shared_kernel.event.EventListener;

public class UserRegistrationConfirmedEventListener implements EventListener<UserRegistrationConfirmedEvent> {

    private  final NotificationsByMail notificationsByMail;

    public UserRegistrationConfirmedEventListener(NotificationsByMail notificationsByMail) {
        this.notificationsByMail = notificationsByMail;
    }

    @Override
    public void listenTo(UserRegistrationConfirmedEvent event) {
        User user = event.getUser();
        notificationsByMail.send(user.getMail(), "You are succesfully registered");
    }
}
