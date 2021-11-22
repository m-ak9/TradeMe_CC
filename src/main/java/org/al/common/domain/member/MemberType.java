package org.al.common.domain.member;

public enum MemberType {
    TRADESMAN("tradesman"),
    CONTRACTOR("contractor");

    private String memberType;

    MemberType(String memberType) {
        this.memberType = memberType;
    }

    public String getMemberType() {
        return this.memberType;
    }

    public static MemberType fromString(String text) {
        for (MemberType val : MemberType.values()) {
            if (val.memberType.equalsIgnoreCase(text)) {
                return val;
            }
        }
        return null;
    }


}
