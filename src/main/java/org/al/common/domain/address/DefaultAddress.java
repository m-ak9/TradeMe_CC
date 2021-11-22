package org.al.common.domain.address;

final class DefaultAddress implements Address {

    private final String city;
    private final String street;
    private final String country;
    private final String zipCode;

    DefaultAddress(String city, String street, String country, String state) {
        this.street = street;
        this.country = country;
        this.zipCode = state;
        this.city = city;
    }

    @Override
    public String city() {
        return this.city;
    }

    @Override
    public String street() {
        return this.street;
    }

    @Override
    public String country() {
        return this.country;
    }

    @Override
    public String zipCode() {
        return this.zipCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street = '" + street + '\'' +
                ", city = '" + city + '\'' +
                ", zipcode = '" + zipCode + '\'' +
                ", country = '" + country + '\'' +
                '}';
    }


}
