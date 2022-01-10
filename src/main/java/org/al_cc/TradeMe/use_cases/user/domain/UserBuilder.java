package org.al_cc.TradeMe.use_cases.user.domain;

public class UserBuilder {
    private String      lastname;
    private String firstname;
    private UserId userId;
    private String login;
    private String      password;
    private Address     address;
    private UserType    userType;
    private String              mail;

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    public UserBuilder withFirstName(String firstnameValue) {
        this.firstname = firstnameValue;
        return this;
    }

    public UserBuilder withLastName(String lastnameValue) {
        this.lastname = lastnameValue;
        return this;
    }

    public UserBuilder withAddress(Address address) {
        if (address instanceof NoAddress)
            throw new IllegalArgumentException("Address is required.");
        this.address = address;
        return this;
    }

    public UserBuilder withUserId(UserId userId) {
        this.userId = userId;
        return this;
    }

    public UserBuilder withLogin(String login) {
        this.login = login;
        return this;
    }

    public UserBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder withUserType(String usertype) {
        this.userType = UserType.fromString(usertype);
        return this;
    }

    public UserBuilder withMail(String mail) {
        this.mail = mail;
        return this;
    }

    public DefaultUser build() {
        return new DefaultUser(
                lastname,
                firstname,
                login,
                userId,
                password,
                address,
                userType,
                mail);
    }


}

