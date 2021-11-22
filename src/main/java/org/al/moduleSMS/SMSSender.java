package org.al.moduleSMS;

import org.al.common.domain.member.Member;
import org.al.common.kernel.Service;

import java.util.logging.Logger;

@Service
public class SMSSender {
    private static final Logger LOGGER = Logger.getLogger(SMSSender.class.getName());

    public void sendSMS(Member member) {
        LOGGER.info("Sending SMS to :\n" + member + "\n");
    }
}
