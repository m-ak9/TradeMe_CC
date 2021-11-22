package org.al.common.domain.member;


import org.al.common.domain.address.Address;
import org.al.common.domain.payment.Payment;
import org.al.common.kernel.Entity;

@Entity
public class NoMember implements Member {

    @Override
    public String getLastname() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getFirstname() {
        throw new UnsupportedOperationException();
    }

    @Override
    public MemberId getUserId() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Address getAddress() {
        throw new UnsupportedOperationException();
    }

    @Override
    public MemberId getMemberId() {
        throw new UnsupportedOperationException();
    }

    @Override
    public MemberType getMemberType() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Payment getPayment() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getPassword() {
        throw new UnsupportedOperationException();
    }

    @Override public String toStringWithAddress() {
        return null;
    }

    @Override public void addUserId(int id) {
        throw new UnsupportedOperationException();
    }
}
