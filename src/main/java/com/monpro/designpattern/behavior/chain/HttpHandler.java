package com.monpro.designpattern.behavior.chain;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HttpHandler extends Handler {

  @Override
  public boolean doHandle() {
    boolean handled = false;
    // TODO: add HttpHandler logic
    log.info("HTTP Handler");
    return handled;
  }
}
