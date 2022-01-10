package org.al_cc.TradeMe.use_cases.payment.domain;

public enum DeviseType {
    EURO("euro"),
    DOLLAR("dollar"),
    NO_DEVISE("no_devise");

    private final String deviseType;

    DeviseType(String deviseType) {
        this.deviseType = deviseType;
    }

    public String getDeviseType() {
        return this.deviseType;
    }

    public static DeviseType fromString(String text) {
        for (DeviseType val : DeviseType.values()) {
            if (val.deviseType.equalsIgnoreCase(text)) {
                return val;
            }
        }
        return null;
    }


}
