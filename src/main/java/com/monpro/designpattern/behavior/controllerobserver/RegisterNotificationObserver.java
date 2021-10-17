package com.monpro.designpattern.behavior.controllerobserver;

import com.google.inject.Inject;

public class RegisterNotificationObserver implements RegisterObserver {

  @Inject
  private NotificationService notificationService;

  @Override
  public void handleRegisterSuccess(long userId) {
    notificationService.sendInBoxMessage(userId, "welcome");
  }
}
