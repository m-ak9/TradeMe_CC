package org.al_cc.TradeMe.use_cases.user.domain;

public enum UserType {
    TRADESMAN("tradesman"),
    CONTRACTOR("contractor");

    private final String memberType;

    UserType(String memberType) {
        this.memberType = memberType;
    }

    public String getMemberType() {
        return this.memberType;
    }

    public static UserType fromString(String text) {
        for (UserType val : UserType.values()) {
            if (val.memberType.equalsIgnoreCase(text)) {
                return val;
            }
        }
        return null;
    }


}
