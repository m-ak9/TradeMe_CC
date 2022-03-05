package org.al_cc.TradeMe.use_cases.user.domain;

public interface Member {

    String getLastname();

    String getFirstname();

    String getLogin();

    MemberId getUserId();

    Address getAddress();

    UserType getUserType();

    String getMail();

    String toString();

    String toStringWithAddress();

    void addUserId(int id);

    void changeAddress(Address address);

}
