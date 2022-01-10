package org.al_cc.shared_kernel;

public interface CommandHandler<C extends Command, R> {
    R handle(C command);
}
