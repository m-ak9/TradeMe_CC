package org.al_cc.TradeMe.use_cases.user.application.command;

import org.al_cc.TradeMe.use_cases.payment.application.command.ProcessPayment;
import org.al_cc.TradeMe.use_cases.user.application.event.CreateUserEvent;
import org.al_cc.TradeMe.use_cases.user.domain.*;
import org.al_cc.TradeMe.use_cases.user.domain.event.UserRegistrationConfirmedEvent;
import org.al_cc.TradeMe.use_cases.user.infrastructure.InMemoryUserRepository;
import org.al_cc.shared_kernel.ApplicationEvent;
import org.al_cc.shared_kernel.CommandHandler;
import org.al_cc.shared_kernel.annotations.Service;
import org.al_cc.shared_kernel.event.DomainEvent;
import org.al_cc.shared_kernel.event.EventDispatcher;


@Service
public class CreateUserCommandHandler implements CommandHandler<CreateUser, UserId> {

    private final UserRepository userRepository;

    private final EventDispatcher<ApplicationEvent> applicationEventDispatcher;
    private final EventDispatcher<DomainEvent>      domainEventDispatcher;


    public CreateUserCommandHandler(UserRepository userRepository,
                                    EventDispatcher<ApplicationEvent> applicationEventDispatcher,
                                    EventDispatcher<DomainEvent> domainEventDispatcher) {
        this.userRepository = InMemoryUserRepository.getInstance();
        this.domainEventDispatcher = domainEventDispatcher;
        this.applicationEventDispatcher = applicationEventDispatcher;
    }

    @Override
    public UserId handle(CreateUser command) {
        final UserId userId = userRepository.nextId();
        final User user = UserBuilder.builder()
                                     .withFirstName(command.firstname)
                                     .withLastName(command.lastname)
                                     .withLogin(command.login)
                                     .withPassword(command.password)
                                     .withUserId(userId)
                                     .withUserType(command.userType)
                                     .withAddress(AddressFactory.create(
                                             command.address.city,
                                             command.address.country,
                                             command.address.street,
                                             command.address.zipCode
                                     ))
                                     .withMail(command.mail)
                                     .build();

        userRepository.add(user);

        ProcessPayment payment = new ProcessPayment(command.payment.methodOfPayment, command.payment.subscriptionPlan, command.payment.transactionId, user.getUserId());
        applicationEventDispatcher.dispatch(CreateUserEvent.withPayment(payment));

        domainEventDispatcher.dispatch(UserRegistrationConfirmedEvent.withUser(user));

        return userId;
    }
}
