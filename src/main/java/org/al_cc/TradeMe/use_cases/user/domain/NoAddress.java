package org.al_cc.TradeMe.use_cases.user.domain;

public final class NoAddress implements Address {
    @Override
    public String city() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String street() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String country() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String zipCode() {
        throw new UnsupportedOperationException();
    }
}
