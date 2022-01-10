package org.al_cc.shared_kernel.event;

import java.time.ZonedDateTime;

public interface Event {

    EventId getId();

    ZonedDateTime getOccurredDate();
}
