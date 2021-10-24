package com.monpro.designpattern.behavior.chain;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AuthHandler extends Handler {

  @Override
  public void handle() {
    boolean handled = false;
    log.info("AUTH Handler");
    // TODO: add HttpHandler logic
    if (!handled && successor != null) {
      successor.handle();
    }
  }
}
