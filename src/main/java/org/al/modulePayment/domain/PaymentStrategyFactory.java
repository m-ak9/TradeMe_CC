package org.al.modulePayment.domain;

import org.al.common.domain.member.Member;
import org.al.common.domain.member.MemberType;
import org.al.common.kernel.NotValidAttributeException;
import org.al.common.kernel.Pattern;

@Pattern
public final class PaymentStrategyFactory {

    private PaymentStrategyFactory() {
        throw new AssertionError();
    }

    public static PaymentStrategy getStrategy(Member member) {
        if (member.getMemberType().equals(MemberType.TRADESMAN))
            return new TradesmanPaymentStrategy();
        if (member.getMemberType().equals(MemberType.CONTRACTOR))
            return new ContractorPaymentStrategy();
        throw new NotValidAttributeException("No payment rules for this category of member.");
    }

}
