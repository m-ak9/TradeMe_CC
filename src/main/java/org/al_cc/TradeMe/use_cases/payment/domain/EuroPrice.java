package org.al_cc.TradeMe.use_cases.payment.domain;

public class EuroPrice implements Price{

    DeviseType deviseType;
    int value;

    public EuroPrice(int value) {
        this.deviseType = DeviseType.EURO;
        this.value = value;
    }

    public static EuroPrice of(int value){
        return new EuroPrice(value);
    }

    @Override public DeviseType getDevise() {
        return this.deviseType;
    }

    @Override public Integer getValue() {
        return this.value;
    }
}
