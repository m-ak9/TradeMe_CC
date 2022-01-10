package org.al_cc.TradeMe.use_cases.user.exposition;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UserRequest {

    @NotNull
    @NotBlank
    public String lastname;

    @NotNull
    @NotBlank
    public String firstname;

    @NotNull
    @NotBlank
    public String login;

    @NotNull
    @NotBlank
    public String password;

    @NotNull
    @NotBlank
    public String memberType;

    @NotNull
    public AddressRequest address;

    @NotNull
    @NotBlank
    public String mail;

    public PaymentRequest payment;
}
