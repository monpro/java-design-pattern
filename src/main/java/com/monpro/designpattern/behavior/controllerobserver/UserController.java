package com.monpro.designpattern.behavior.controllerobserver;

import java.util.ArrayList;
import java.util.List;

public class UserController {

  private final List<RegisterObserver> registerObservers = new ArrayList<>();

  public void setObservers(final List<RegisterObserver> observers) {
    registerObservers.addAll(observers);
  }

  public Long register(final String userName) {
    // UserId is always 1 for demo
    registerObservers.forEach(registerObserver -> registerObserver.handleRegisterSuccess(1));
    return 1L;
  }
}
