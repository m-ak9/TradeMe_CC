package org.al_cc.shared_kernel.exceptions;

import org.al_cc.shared_kernel.ValueObjectID;

public final class NoSuchEntityException extends RuntimeException {

    public NoSuchEntityException(String message) {
        super(message);
    }

    public static <VOID extends ValueObjectID> NoSuchEntityException withId(VOID id) {
        return new NoSuchEntityException(String.format("No entity found with ID %s.", id.getValue()));
    }
}
