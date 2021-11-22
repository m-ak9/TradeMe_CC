package org.al.common.domain.address;

import org.al.common.kernel.Validator;

import java.util.function.Predicate;

@Validator
public final class AddressValidator implements Predicate<Address> {

    private static final AddressValidator INSTANCE = new AddressValidator();

    public static AddressValidator getInstance() {
        return INSTANCE;
    }

    @Override
    public boolean test(Address address) {

        if (address.country().isEmpty())
            throw new IllegalArgumentException("The country cannot be empty.");
        if (address.city().isEmpty())
            throw new IllegalArgumentException("The city cannot be empty.");
        if (address.street().isEmpty())
            throw new IllegalArgumentException("The street cannot be empty.");
        if (address.zipCode().isEmpty())
            throw new IllegalArgumentException("The zipcode cannot be empty.");

        return true;
    }
}
