package org.al_cc.shared_kernel;

public interface QueryBus {
    <Q extends Query, R> R send(Q query);
}
