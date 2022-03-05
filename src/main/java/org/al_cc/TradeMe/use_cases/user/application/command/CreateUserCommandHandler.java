package org.al_cc.TradeMe.use_cases.user.application.command;

import org.al_cc.TradeMe.use_cases.user.application.PaymentDTO;
import org.al_cc.TradeMe.use_cases.user.application.event.ProcessPaymentEvent;
import org.al_cc.TradeMe.use_cases.user.domain.*;
import org.al_cc.TradeMe.use_cases.user.domain.event.UserCreatedEvent;
import org.al_cc.TradeMe.use_cases.user.infrastructure.InMemoryUserRepository;
import org.al_cc.shared_kernel.ApplicationEvent;
import org.al_cc.shared_kernel.CommandHandler;
import org.al_cc.shared_kernel.annotations.Service;
import org.al_cc.shared_kernel.event.DomainEvent;
import org.al_cc.shared_kernel.event.EventDispatcher;


@Service
public class CreateUserCommandHandler implements CommandHandler<CreateUser, MemberId> {

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
    public MemberId handle(CreateUser command) {
        final MemberId memberId = userRepository.nextId();
        final Member member = UserBuilder.builder()
                                       .withFirstName(command.firstname)
                                       .withLastName(command.lastname)
                                       .withLogin(command.login)
                                       .withPassword(command.password)
                                       .withMemberId(memberId)
                                       .withMemberType(command.userType)
                                       .withAddress(AddressFactory.create(
                                             command.address.city,
                                             command.address.country,
                                             command.address.street,
                                             command.address.zipCode
                                     ))
                                       .withMail(command.mail)
                                       .build();
        userRepository.add(member);

        PaymentDTO paymentDTO = new PaymentDTO(command.payment.methodOfPayment, command.payment.subscriptionPlan, command.payment.transactionId);
        applicationEventDispatcher.dispatch(ProcessPaymentEvent.withPayment(memberId, paymentDTO));

        domainEventDispatcher.dispatch(UserCreatedEvent.withUser(member));

        return memberId;
    }
}
