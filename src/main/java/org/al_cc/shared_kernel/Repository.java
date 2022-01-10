package org.al_cc.shared_kernel;

import org.al_cc.shared_kernel.exceptions.NoSuchEntityException;

public interface Repository<VOID, E> {
    VOID nextIdentity();

    E findById(VOID id) throws NoSuchEntityException;

    void add(E entity);

    void delete(VOID id);
}
