package org.al.common.domain.member;


import org.al.common.domain.address.Address;
import org.al.common.domain.payment.Payment;
import org.al.common.kernel.Entity;

import java.util.Objects;

@Entity
public class DefaultMember implements Member {
    private final String     lastname;
    private final String     firstname;
    private       MemberId   memberId;
    private final String     password;
    private final Address    address;
    private final MemberType memberType;
    private final Payment    payment;

    DefaultMember(String lastname,
                  String firstname,
                  MemberId memberId,
                  String password,
                  Address address,
                  MemberType memberType, Payment payment) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.memberId = memberId;
        this.password = password;
        this.address = address;
        this.memberType = memberType;
        this.payment = payment;
    }

    public static DefaultMember of(String lastname,
                                   String firstname,
                                   MemberId memberId,
                                   String password,
                                   Address address,
                                   MemberType memberType,
                                   Payment payment) {
        return new DefaultMember(lastname, firstname, memberId, password, address, memberType, payment);
    }

    @Override
    public String getLastname() {
        return lastname;
    }

    @Override
    public String getFirstname() {
        return firstname;
    }

    @Override
    public MemberId getUserId() {
        return memberId;
    }

    @Override
    public Address getAddress() {
        return address;
    }

    @Override
    public MemberId getMemberId() {
        return memberId;
    }

    @Override
    public MemberType getMemberType() {
        return memberType;
    }

    @Override
    public Payment getPayment() {
        return payment;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public void addUserId(int id) {
        this.memberId = new MemberId(id);
    }

    @Override
    public String toString() {
        return "User{ " +
                "userId = '" + (Objects.isNull(memberId) ? "" : memberId.getValue()) + '\'' +
                ", lastname = '" + lastname + '\'' +
                ", firstname = '" + firstname + '\'' +
                ", type = '" + memberType.getMemberType() + '\'' +
                '}';
    }

    @Override
    public String toStringWithAddress() {
        return "User{" +
                "userId = '" + (Objects.isNull(memberId) ? "" : memberId.getValue()) + '\'' +
                ", lastname = '" + lastname + '\'' +
                ", firstname = '" + firstname + '\'' +
                ", type = '" + memberType.getMemberType() + '\'' +
                "\n" + address.toString() +
                '}';
    }


}
