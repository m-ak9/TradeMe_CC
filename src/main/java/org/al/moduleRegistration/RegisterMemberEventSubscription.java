package org.al.moduleRegistration;


import org.al.common.domain.RegisterMemberEvent;
import org.al.event.Subscriber;
import org.al.moduleRegistration.domain.RegisterService;

public class RegisterMemberEventSubscription implements Subscriber<RegisterMemberEvent> {

    private final RegisterService registerService;

    public RegisterMemberEventSubscription() {
        this.registerService = new RegisterServiceDefault();
    }

    @Override
    public void accept(RegisterMemberEvent event) {
        var user = event.getMember();
        registerService.register(user);
    }
}
