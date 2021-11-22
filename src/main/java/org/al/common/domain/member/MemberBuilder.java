package org.al.common.domain.member;

import org.al.common.domain.address.Address;
import org.al.common.domain.address.NoAddress;
import org.al.common.domain.payment.Payment;

import java.time.LocalDate;
import java.util.Objects;

public class MemberBuilder {
    private String         lastname;
    private String         firstname;
    private MemberId       memberId;
    private String         password;
    private Address        address;
    private MemberType     memberType;
    private PaymentBuilder paymentBuilder;

    public MemberBuilder() {
        this.paymentBuilder = new PaymentBuilder();
    }

    public static MemberBuilder builder() {
        return new MemberBuilder();
    }

    public MemberBuilder withFirstName(String firstnameValue) {
        this.firstname = firstnameValue;
        return this;
    }

    public MemberBuilder withLastName(String lastnameValue) {
        this.lastname = lastnameValue;
        return this;
    }

    public MemberBuilder withAddress(Address address) {
        if (address instanceof NoAddress)
            throw new IllegalArgumentException("Address is required.");
        this.address = address;
        return this;
    }

    public MemberBuilder withMemberId(MemberId memberId) {
        this.memberId = memberId;
        return this;
    }

    public MemberBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public MemberBuilder withMemberType(String memberType) {
        this.memberType = MemberType.fromString(memberType);
        return this;
    }

    public PaymentBuilder withPayment() {
        return paymentBuilder;
    }

    public DefaultMember build() {
        return new DefaultMember(lastname,
                firstname,
                memberId,
                password,
                address,
                memberType,
                new Payment(paymentBuilder.creditCardNumber, paymentBuilder.expirationDate, paymentBuilder.ccv)
        );
    }

    public class PaymentBuilder {

        private String    creditCardNumber;
        private LocalDate expirationDate;
        private String    ccv;

        public PaymentBuilder creditCardNumber(String creditCardNumber) {
            PaymentBuilder paymentBuilder = new PaymentBuilder();
            paymentBuilder.creditCardNumber = creditCardNumber;
            paymentBuilder.expirationDate = expirationDate;
            paymentBuilder.ccv = ccv;
            return paymentBuilder;
        }

        public PaymentBuilder expirationDate(LocalDate expirationDate) {
            PaymentBuilder paymentBuilder = new PaymentBuilder();
            paymentBuilder.creditCardNumber = creditCardNumber;
            paymentBuilder.expirationDate = expirationDate;
            paymentBuilder.ccv = ccv;
            return paymentBuilder;
        }

        public PaymentBuilder ccv(String ccv) {
            PaymentBuilder paymentBuilder = new PaymentBuilder();
            paymentBuilder.creditCardNumber = creditCardNumber;
            paymentBuilder.expirationDate = expirationDate;
            paymentBuilder.ccv = ccv;
            return paymentBuilder;
        }

        public MemberBuilder end() {
            if (!creditCardNumber.isEmpty() && Objects.nonNull(expirationDate) && !ccv.isEmpty()) {
                MemberBuilder.this.paymentBuilder = this;
                return MemberBuilder.this;
            }
            throw new IllegalArgumentException("The payment informations is required.");
        }
    }
}

