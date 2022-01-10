package org.al_cc.TradeMe.use_cases.payment.domain;

import java.util.Objects;

public final class TransactionId {
    private final String value;

    public TransactionId(String value) {
        this.value = value;
    }

    public static TransactionId of(String value) {
        return new TransactionId(value);
    }

    public String getValue() {
        return value;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionId that = (TransactionId) o;
        return Objects.equals(value, that.value);
    }

    @Override public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "TransactionId{" +
                "value=" + value +
                '}';
    }
}
