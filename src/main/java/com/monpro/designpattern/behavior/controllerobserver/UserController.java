package com.monpro.designpattern.behavior.controllerobserver;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class UserController {

  private final List<RegisterObserver> registerObservers = new ArrayList<>();
  final ExecutorService executor = Executors.newFixedThreadPool(10);

  public void setObservers(final List<RegisterObserver> observers) {
    registerObservers.addAll(observers);
  }

  public Long register(final String userName) {
    // UserId is always 1 for demo
    registerObservers.forEach(
        registerObserver -> executor.execute(
            () -> {
              log.info("Current Thread Id: {}", Thread.currentThread().getId());
              registerObserver.handleRegisterSuccess(1);
            }));
    return 1L;
  }
}
