package org.al_cc.TradeMe.use_cases.user.domain;

public interface User {

    String getLastname();

    String getFirstname();

    String getLogin();

    UserId getUserId();

    Address getAddress();

    UserType getUserType();

    String getMail();

    String toString();

    String toStringWithAddress();

    void addUserId(int id);

    void changeAddress(Address address);

}
