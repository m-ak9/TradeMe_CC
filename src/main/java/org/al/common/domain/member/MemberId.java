package org.al.common.domain.member;

public final class MemberId {

    private final int value;

    public MemberId(int value) {
        this.value = value;
    }

    public static MemberId of(int value) {
        return new MemberId(value);
    }

    public String getValue() {
        return String.valueOf(value);
    }
}
