package org.al.moduleRegistration;

import org.al.common.domain.ProcessPaymentEvent;
import org.al.common.domain.member.Member;
import org.al.common.domain.member.MemberService;
import org.al.moduleEventBusProvider.EventBusProvider;
import org.al.moduleRegistration.domain.RegisterService;

import java.util.logging.Logger;

public class RegisterServiceDefault implements RegisterService {
    private static final Logger LOGGER = Logger.getLogger(RegisterServiceDefault.class.getName());

    private final MemberService memberService = new MemberServiceDefault();


    public RegisterServiceDefault() {
    }

    public void register(Member member) {
        LOGGER.info("Registering \n" + member.toStringWithAddress() + "\n");

        Member savedMember = memberService.save(member);
        LOGGER.info("Saved :\n" + member.toString() + "\n");

        EventBusProvider.getInstance().getEventBus().send(ProcessPaymentEvent.withMember(savedMember));
    }
}
