package org.al_cc.TradeMe.use_cases.user.domain;


import java.util.Objects;


public class DefaultUser implements User {
    private final String     lastname;
    private final String firstname;
    private final String    login;
    private       UserId userId;
    private final String    password;
    private       Address  address;
    private final UserType userType;
    private final String   mail;

    DefaultUser(String lastname, String firstname, String login, UserId userId, String password, Address address,
                UserType userType, String mail) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.login = login;
        this.userId = userId;
        this.password = password;
        this.address = address;
        this.userType = userType;
        this.mail = mail;
    }

    public static DefaultUser of(String lastname, String firstname, String login, UserId userId, String password,
                                 Address address, UserType userType, String mail) {
        return new DefaultUser(lastname, firstname, login, userId, password, address, userType, mail);
    }

    @Override
    public String getLastname() {
        return lastname;
    }

    @Override
    public String getFirstname() {
        return firstname;
    }

    @Override
    public String getLogin() {
        return login;
    }

    @Override
    public UserId getUserId() {
        return userId;
    }

    @Override
    public Address getAddress() {
        return address;
    }

    @Override
    public UserType getUserType() {
        return userType;
    }

    @Override
    public String getMail() {
        return mail;
    }

    @Override
    public void addUserId(int id) {
        this.userId = new UserId(id);
    }

    @Override
    public void changeAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{ " +
                "userId = '" + (Objects.isNull(userId) ? "" : userId.getValue()) + '\'' +
                ", lastname = '" + lastname + '\'' +
                ", firstname = '" + firstname + '\'' +
                ", type = '" + userType.getMemberType() + '\'' +
                ", mail = '" + mail + '\'' +
                '}';
    }

    @Override
    public String toStringWithAddress() {
        return "User{" +
                "userId = '" + (Objects.isNull(userId) ? "" : userId.getValue()) + '\'' +
                ", lastname = '" + lastname + '\'' +
                ", firstname = '" + firstname + '\'' +
                ", type = '" + userType.getMemberType() + '\'' +
                "\n" + address.toString() +
                ", mail = '" + mail + '\'' +
                '}';
    }


}
