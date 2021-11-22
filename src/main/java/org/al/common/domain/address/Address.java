package org.al.common.domain.address;

public interface Address {
    String city();
    String street();
    String country();
    String zipCode();

    String toString();
}
