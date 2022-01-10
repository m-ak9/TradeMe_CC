package org.al_cc.TradeMe.use_cases.user.application.command;

import org.al_cc.TradeMe.use_cases.user.application.AddressDTO;
import org.al_cc.TradeMe.use_cases.user.application.PaymentDTO;
import org.al_cc.shared_kernel.Command;

/**
 * Command object
 */
@SuppressWarnings("all")
public final class CreateUser implements Command {

    public final String  lastname;
    public final String  firstname;
    public final String  login;
    public final String  password;
    public final String     userType;
    public final AddressDTO address;
    public final String     mail;
    public final PaymentDTO payment;

    public CreateUser(String lastname,
                      String firstname,
                      String login,
                      String password,
                      String userType,
                      AddressDTO address,
                      String mail,
                      PaymentDTO payment) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.login = login;
        this.password = password;
        this.userType = userType;
        this.address = address;
        this.mail = mail;
        this.payment = payment;
    }
}
