package com.monpro.designpattern.behavior.controllerobserver;

import com.google.inject.Guice;
import com.google.inject.Injector;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    final Injector injector = Guice.createInjector(new RegisterModule());
    final UserController userController = injector.getInstance(UserController.class);
    final RegisterNotificationObserver registerNotificationObserver = injector.getInstance(RegisterNotificationObserver.class);
    final RegisterPromotionObserver registerPromotionObserver = injector.getInstance(RegisterPromotionObserver.class);
    final List<RegisterObserver> observerList = new ArrayList<>();
    observerList.add(registerNotificationObserver);
    observerList.add(registerPromotionObserver);
    userController.setObservers(observerList);
    userController.register("mon");
  }
}
