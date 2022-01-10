package org.al_cc.shared_kernel.event;

import java.util.List;

public interface EventBus<E extends Event> {
    void send(E event);

    void registerSubscriber(Class<E> classE, List<Subscriber<E>> subscribers);
}
