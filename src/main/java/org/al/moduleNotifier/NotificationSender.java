package org.al.moduleNotifier;


import org.al.common.domain.member.Member;
import org.al.common.kernel.Service;

import java.util.logging.Logger;

@Service
public class NotificationSender {
    private static final Logger LOGGER = Logger.getLogger(NotificationSender.class.getName());

    public void foundMember(Member member) {
        LOGGER.info(member.getFirstname() + " " + member.getLastname() + " is succesfully registered and payment is done.\n");
    }
}
