package org.al_cc.TradeMe.use_cases.user.infrastructure;

import org.al_cc.TradeMe.use_cases.user.domain.Notifications;

import java.util.logging.Logger;

public class NotificationsByMail implements Notifications {
    private static final Logger LOGGER = Logger.getLogger(NotificationsByMail.class.getName());

    @Override
    public void send(String destinataire, String message) {
        LOGGER.info(" Mail sended to " + destinataire + " with content :\n" + message);
    }
}
