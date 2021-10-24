package com.monpro.designpattern.behavior.chain;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HttpHandler extends Handler {

  @Override
  public void handle() {
    boolean handled = false;
    // TODO: add HttpHandler logic
    log.info("HTTP Handler");
    if (!handled && successor != null) {
      successor.handle();
    }
  }
}
