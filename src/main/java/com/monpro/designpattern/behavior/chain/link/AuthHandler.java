package com.monpro.designpattern.behavior.chain.link;

import com.monpro.designpattern.behavior.chain.link.Handler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AuthHandler extends Handler {

  @Override
  public boolean doHandle() {
    boolean handled = false;
    log.info("AUTH Handler");
    // TODO: add HttpHandler logic
    return handled;
  }
}
