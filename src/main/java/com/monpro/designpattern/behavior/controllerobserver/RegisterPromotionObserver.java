package com.monpro.designpattern.behavior.controllerobserver;

import com.google.inject.Inject;

public class RegisterPromotionObserver implements RegisterObserver {

  @Inject
  private PromotionService promotionService;

  @Override
  public void handleRegisterSuccess(long userId) {
    promotionService.issueNewUserExperienceCash(userId);
  }
}
