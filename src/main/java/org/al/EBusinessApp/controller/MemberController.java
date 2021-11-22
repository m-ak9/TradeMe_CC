package org.al.EBusinessApp.controller;

import org.al.common.GetMemberEvent;
import org.al.common.domain.RegisterMemberEvent;
import org.al.common.domain.address.AddressFactory;
import org.al.common.domain.member.Member;
import org.al.common.domain.member.MemberBuilder;
import org.al.common.domain.member.MemberId;
import org.al.common.kernel.Controller;
import org.al.moduleEventBusProvider.EventBusProvider;

import java.util.logging.Logger;

@Controller
public class MemberController {
    private static final Logger LOGGER = Logger.getLogger(MemberController.class.getName());

    public static void addMember(Member newMember) {
        LOGGER.info("Request received for registering User" + "\n");

        // create Member from body of the request
        Member member = MemberBuilder.builder()
                                     .withLastName(newMember.getLastname())
                                     .withFirstName(newMember.getFirstname())
                                     .withPassword(newMember.getPassword())
                                     .withMemberType(newMember.getMemberType().getMemberType())
                                     .withAddress(AddressFactory.create(
                                             newMember.getAddress().city(),
                                             newMember.getAddress().country(),
                                             newMember.getAddress().street(),
                                             newMember.getAddress().zipCode()))
                                     .withPayment()
                                     .creditCardNumber(newMember.getPayment().getCreditCardNumber())
                                     .expirationDate(newMember.getPayment().getExpirationDate())
                                     .ccv(newMember.getPayment().getCcv())
                                     .end()
                                     .build();

        EventBusProvider.getInstance().getEventBus().send(RegisterMemberEvent.withMember(member));
    }

    public static void getMemberById(int id) {
        LOGGER.info("Request received for getting Member by ID" + "\n");

        // create MemberId from path variable of the request
        MemberId memberId = new MemberId(id);

        EventBusProvider.getInstance().getEventBus().send(GetMemberEvent.withMemberId(memberId));

    }
}
