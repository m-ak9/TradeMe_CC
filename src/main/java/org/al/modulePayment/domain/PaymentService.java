package org.al.modulePayment.domain;

import org.al.common.domain.member.Member;

public interface PaymentService {

    void process(Member member);
}
