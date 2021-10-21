package com.monpro.designpattern.behavior.moneventbus;

import com.google.common.util.concurrent.MoreExecutors;

import java.util.List;
import java.util.concurrent.Executor;

public class EventBus {
  private Executor executor;
  private ObserverRegistry registry = new ObserverRegistry();

  public EventBus() {
    this(MoreExecutors.directExecutor());
  }

  public EventBus(final Executor executor) {
    this.executor = executor;
  }

  public void post(final Object event) {
    final List<ObserverAction> matchedObservedActions = registry.findMatchedObservedActions(event);
    matchedObservedActions.forEach(
        observerAction -> executor.execute(() -> observerAction.execute(event)));
  }
}
