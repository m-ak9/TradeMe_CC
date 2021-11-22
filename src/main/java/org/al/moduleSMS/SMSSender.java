package org.al.moduleSMS;

import org.al.common.domain.member.Member;

import java.util.logging.Logger;

public class SMSSender {
    private static final Logger LOGGER = Logger.getLogger(SMSSender.class.getName());

    public void sendSMS(Member member) {
        LOGGER.info("Sending SMS to :\n" + member + "\n");
    }
}
