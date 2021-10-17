package com.monpro.designpattern.behavior.controllerobserver;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NotificationService {
  public void sendInBoxMessage(final long userId, final String welcome) {
    log.info("Send Message : {} for user: {}", welcome, userId);
  }
}
