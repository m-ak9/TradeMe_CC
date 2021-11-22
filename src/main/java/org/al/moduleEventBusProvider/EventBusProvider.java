package org.al.moduleEventBusProvider;

import org.al.event.Event;
import org.al.event.EventBus;

public class EventBusProvider {
    private static final EventBusProvider INSTANCE = new EventBusProvider();
    private final        EventBus<Event>  eventBus;

    private EventBusProvider() {
        EventBusLoader<Event> eventBusLoader = new EventBusLoader<>();
        this.eventBus = eventBusLoader.load();
    }

    public static EventBusProvider getInstance() {
        return INSTANCE;
    }

    public EventBus<Event> getEventBus() {
        return this.eventBus;
    }

}