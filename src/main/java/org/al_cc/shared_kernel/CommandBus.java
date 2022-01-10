package org.al_cc.shared_kernel;

import org.al_cc.shared_kernel.annotations.Service;

@Service
public interface CommandBus {
    <C extends Command, R> R send(C command);
}
