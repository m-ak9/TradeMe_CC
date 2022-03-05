package org.al_cc.TradeMe.use_cases.user.domain;

public class NoMember implements Member {
    @Override public String getLastname() {
        throw new UnsupportedOperationException();
    }

    @Override public String getFirstname() {
        throw new UnsupportedOperationException();
    }

    @Override public String getLogin() {
        throw new UnsupportedOperationException();
    }

    @Override public MemberId getUserId() {
        throw new UnsupportedOperationException();
    }

    @Override public Address getAddress() {
        throw new UnsupportedOperationException();
    }

    @Override public UserType getUserType() {
        throw new UnsupportedOperationException();
    }

    @Override public String getMail() {
        throw new UnsupportedOperationException();
    }

    @Override public String toStringWithAddress() {
        throw new UnsupportedOperationException();
    }

    @Override public void addUserId(int id) {
        throw new UnsupportedOperationException();
    }

    @Override public void changeAddress(Address address) {
        throw new UnsupportedOperationException();
    }
}
