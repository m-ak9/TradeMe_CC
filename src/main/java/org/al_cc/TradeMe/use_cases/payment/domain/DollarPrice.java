package org.al_cc.TradeMe.use_cases.payment.domain;

public class DollarPrice implements Price{

    DeviseType deviseType;
    int value;

    public DollarPrice(int value) {
        this.deviseType = DeviseType.DOLLAR;
        this.value = value;
    }

    public static DollarPrice of(int value){
        return new DollarPrice( value);
    }

    @Override public DeviseType getDevise() {
        return this.deviseType;
    }

    @Override public Integer getValue() {
        return this.value;
    }
}
