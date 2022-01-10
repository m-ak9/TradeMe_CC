package org.al_cc.TradeMe.use_cases.user.domain;

public interface Address {
    String city();
    String street();
    String country();
    String zipCode();
    String toString();
}
