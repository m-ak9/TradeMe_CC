package org.al.moduleMail;


import org.al.common.domain.member.Member;

import java.util.logging.Logger;

public class MemberMailSender {
    private static final Logger LOGGER = Logger.getLogger(MemberMailSender.class.getName());

    public void sendMail(Member member) {
        LOGGER.info("Sending Email to :\n" + member + "\n");
    }
}
