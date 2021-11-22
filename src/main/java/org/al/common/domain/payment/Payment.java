package org.al.common.domain.payment;

import java.time.LocalDate;

public class Payment {

    private String    creditCardNumber;
    private LocalDate expirationDate;
    private String    ccv;

    public Payment(String creditCardNumber, LocalDate expirationDate, String ccv) {
        this.creditCardNumber = creditCardNumber;
        this.expirationDate = expirationDate;
        this.ccv = ccv;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public String getCcv() {
        return ccv;
    }
}
