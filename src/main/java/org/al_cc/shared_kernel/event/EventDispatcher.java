package org.al_cc.shared_kernel.event;

public interface EventDispatcher<E extends Event> {
    void dispatch(E event);
}
