package org.al.moduleEventBusProvider;

import org.al.common.domain.GetMemberEvent;
import org.al.common.domain.ApprovedMemberEvent;
import org.al.common.domain.ProcessPaymentEvent;
import org.al.common.domain.RegisterMemberEvent;
import org.al.event.DefaultEventBus;
import org.al.event.Event;
import org.al.event.EventBus;
import org.al.event.Subscriber;
import org.al.moduleMail.ApprovedMemberEventSubscription;
import org.al.modulePayment.ProcessPaymentEventSubscription;
import org.al.moduleRegistration.RegisterMemberEventSubscription;

import java.util.HashMap;
import java.util.List;

public class EventBusLoader<E extends Event> {

    EventBusLoader() {}

    EventBus<Event> load() {
        var subscriptionMap = new HashMap<Class<E>, List<Subscriber<? extends Event>>>();

        subscriptionMap.put(
                (Class<E>) ProcessPaymentEvent.class,
                List.of(new ProcessPaymentEventSubscription())
        );
        subscriptionMap.put(
                (Class<E>) RegisterMemberEvent.class,
                List.of(new RegisterMemberEventSubscription())
        );
        subscriptionMap.put(
                (Class<E>) ApprovedMemberEvent.class,
                List.of(
                        new ApprovedMemberEventSubscription(),
                        new org.al.moduleSMS.ApprovedMemberEventSubscription()
                )
        );
        subscriptionMap.put(
                (Class<E>) GetMemberEvent.class,
                List.of(
                        new org.al.moduleQuery.GetMemberEventSubscription(),
                        new org.al.moduleNotifier.GetMemberEventSubscription()
                )
        );

        return new DefaultEventBus(subscriptionMap);
    }
}
