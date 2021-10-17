package com.monpro.designpattern.behavior.controllerobserver;

import com.google.inject.AbstractModule;

public class RegisterModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(PromotionService.class).toInstance(new PromotionService(100));
    bind(NotificationService.class).toInstance(new NotificationService());
  }

}
