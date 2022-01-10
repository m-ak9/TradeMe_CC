package org.al_cc.TradeMe.use_cases.user.exposition;

public class AddressRequest {

    public String city;
    public String country;
    public String street;
    public String zipcode;

    @Override
    public String toString() {
        return "AddressDTO{" +
                "city='" + city + '\'' +
                "country='" + country + '\'' +
                "street='" + street + '\'' +
                "zipcode='" + zipcode + '\'' +
                '}';
    }
}
