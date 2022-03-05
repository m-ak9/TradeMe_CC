package org.al_cc.TradeMe.use_cases.payment.domain.event;

import org.al_cc.TradeMe.use_cases.user.domain.Member;
import org.al_cc.TradeMe.use_cases.user.infrastructure.NotificationsByMail;
import org.al_cc.shared_kernel.event.EventListener;

public class UserSubscriptionConfirmedEventListener implements EventListener<UserSubscriptionConfirmedEvent> {

    private  final NotificationsByMail notificationsByMail;

    public UserSubscriptionConfirmedEventListener(NotificationsByMail notificationsByMail) {
        this.notificationsByMail = notificationsByMail;
    }

    @Override
    public void listenTo(UserSubscriptionConfirmedEvent event) {
        Member user = event.getUser();
        notificationsByMail.send(
                user.getMail(),
                "Payment is successful for " + event.getUser().getLogin() + " he is now subscribed for " +
                        event.getPayment().getSubscriptionPlan().getSubscriptionType().toString() + " plan !"
        );
    }
}
