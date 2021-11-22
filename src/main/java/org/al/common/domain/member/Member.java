package org.al.common.domain.member;

import org.al.common.domain.address.Address;
import org.al.common.domain.payment.Payment;

public interface Member {

    String getLastname();

    String getFirstname();

    MemberId getUserId();

    Address getAddress();

    MemberId getMemberId();

    MemberType getMemberType();

    Payment getPayment();

    String getPassword();

    String toString();

    String toStringWithAddress();

    void addUserId(int id);

}
