package org.al_cc.TradeMe.use_cases.payment.domain;

import org.al_cc.shared_kernel.ValueObjectID;

import java.util.Objects;

public final class PaymentId implements ValueObjectID {
    private final int value;

    public PaymentId(int value) {
        this.value = value;
    }

    public static PaymentId of(int value) {
        return new PaymentId(value);
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentId paymentId = (PaymentId) o;
        return value == paymentId.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "PaymentId{" +
                "value=" + value +
                '}';
    }
}
