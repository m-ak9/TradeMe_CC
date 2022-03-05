package org.al_cc.TradeMe.use_cases.user;

import org.al_cc.TradeMe.use_cases.payment.application.command.ProcessPayment;
import org.al_cc.TradeMe.use_cases.payment.application.command.ProcessPaymentCommandHandler;
import org.al_cc.TradeMe.use_cases.payment.application.event.ProcessPaymentEventListener;
import org.al_cc.TradeMe.use_cases.payment.application.service.PaymentServiceDefault;
import org.al_cc.TradeMe.use_cases.payment.domain.PaymentRepository;
import org.al_cc.TradeMe.use_cases.payment.domain.PaymentService;
import org.al_cc.TradeMe.use_cases.payment.domain.event.UserSubscriptionConfirmedEvent;
import org.al_cc.TradeMe.use_cases.payment.domain.event.UserSubscriptionConfirmedEventListener;
import org.al_cc.TradeMe.use_cases.payment.infrastructure.InMemoryPaymentRepository;
import org.al_cc.TradeMe.use_cases.user.application.command.CreateUser;
import org.al_cc.TradeMe.use_cases.user.application.command.CreateUserCommandHandler;
import org.al_cc.TradeMe.use_cases.user.application.event.ProcessPaymentEvent;
import org.al_cc.TradeMe.use_cases.user.application.query.*;
import org.al_cc.TradeMe.use_cases.user.domain.UserRepository;
import org.al_cc.TradeMe.use_cases.user.domain.event.UserCreatedEvent;
import org.al_cc.TradeMe.use_cases.user.domain.event.UserCreatedEventListener;
import org.al_cc.TradeMe.use_cases.user.exposition.UserResponseAdapter;
import org.al_cc.TradeMe.use_cases.user.infrastructure.DefaultEventDispatcher;
import org.al_cc.TradeMe.use_cases.user.infrastructure.InMemoryUserRepository;
import org.al_cc.TradeMe.use_cases.user.infrastructure.NotificationsByMail;
import org.al_cc.shared_kernel.*;
import org.al_cc.shared_kernel.annotations.Configuration;
import org.al_cc.shared_kernel.event.DomainEvent;
import org.al_cc.shared_kernel.event.Event;
import org.al_cc.shared_kernel.event.EventDispatcher;
import org.al_cc.shared_kernel.event.EventListener;

import javax.enterprise.context.Dependent;
import javax.inject.Singleton;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class UserConfiguration {

    //Application event bus
    @Dependent
    public EventDispatcher<ApplicationEvent> applicationEventDispatcher() {
        final Map<Class<? extends Event>, List<EventListener<? extends Event>>> listenerMap = new HashMap<>();
        listenerMap.put(ProcessPaymentEvent.class, List.of(new ProcessPaymentEventListener(paymentService())));
        return new DefaultEventDispatcher(listenerMap);
    }

    //Domain event bus
    @Dependent
    public EventDispatcher<DomainEvent> domainEventDispatcher() {
        final Map<Class<? extends Event>, List<EventListener<? extends Event>>> listenerMap = new HashMap<>();
        listenerMap.put(UserCreatedEvent.class, List.of(new UserCreatedEventListener(new NotificationsByMail())));
        listenerMap.put(UserSubscriptionConfirmedEvent.class, List.of(new UserSubscriptionConfirmedEventListener(new NotificationsByMail())));
        return new DefaultEventDispatcher(listenerMap);
    }

    //Command bus
    @Dependent
    public CommandBus commandBus() {
        final Map<Class<? extends Command>, CommandHandler> commandHandlerMap = new HashMap<>();
        commandHandlerMap.put(CreateUser.class, new CreateUserCommandHandler(userRepository(), applicationEventDispatcher(), domainEventDispatcher()));
        commandHandlerMap.put(ProcessPayment.class, new ProcessPaymentCommandHandler(paymentService()));
        return new SimpleCommandBus(commandHandlerMap);
    }

    //Query bus
    @Dependent
    public QueryBus queryBus() {
        final Map<Class<? extends Query>, QueryHandler> queryHandlerMap = new HashMap<>();
        queryHandlerMap.put(RetrieveUsers.class, new RetrieveUsersHandler(userRepository()));
        queryHandlerMap.put(RetrieveUserById.class, new RetrieveUserByIdHandler(userRepository()));
        queryHandlerMap.put(RetrieveUsersByCity.class, new RetrieveUsersByCityHandler(userRepository()));
        return new SimpleQueryBus(queryHandlerMap);
    }

    //Repository beans
    @Singleton
    public UserRepository userRepository() {
        return InMemoryUserRepository.getInstance();
    }

    @Singleton
    public PaymentRepository paymentRepository() {
        return InMemoryPaymentRepository.getInstance();
    }

    //Service beans
    @Singleton
    public PaymentService paymentService() {
        return new PaymentServiceDefault(paymentRepository(), userRepository(), domainEventDispatcher());
    }

    //Adapter beans
    @Dependent
    public UserResponseAdapter userResponseAdapter() {
        return new UserResponseAdapter();
    }

}
