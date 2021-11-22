package org.al.moduleMail;


import org.al.common.domain.member.Member;
import org.al.common.kernel.Service;

import java.util.logging.Logger;

@Service
public class MemberMailSender {
    private static final Logger LOGGER = Logger.getLogger(MemberMailSender.class.getName());

    public void sendMail(Member member) {
        LOGGER.info("Sending Email to :\n" + member + "\n");
    }
}
