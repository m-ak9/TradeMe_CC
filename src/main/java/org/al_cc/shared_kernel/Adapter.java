package org.al_cc.shared_kernel;

public interface Adapter<S, D> {
  D adapt(S source);
}
