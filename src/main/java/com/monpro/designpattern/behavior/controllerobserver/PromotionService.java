package com.monpro.designpattern.behavior.controllerobserver;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PromotionService {

  private final long promotionNum;

  public PromotionService(long promotionNum) {
    this.promotionNum = promotionNum;
  }

  public void issueNewUserExperienceCash(final long userId) {
    log.info("issue cash {} for user {}", this.promotionNum, userId);
  }
}
