package org.al_cc.TradeMe.use_cases.payment.domain;

public class NoPrice implements Price{

    DeviseType deviseType;
    int value;

    public NoPrice() {
        this.deviseType = DeviseType.NO_DEVISE;
        this.value = 0;
    }


    @Override public DeviseType getDevise() {
        return this.deviseType;
    }

    @Override public Integer getValue() {
        return this.value;
    }
}
