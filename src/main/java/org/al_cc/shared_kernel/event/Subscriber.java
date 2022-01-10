package org.al_cc.shared_kernel.event;

import java.util.function.Consumer;

public interface Subscriber<E extends Event> extends Consumer<E> {

}
