package com.monpro.designpattern.behavior.chain;

public class HandlerChain {
  private Handler head = null;
  private Handler tail = null;

  public void addHandler(final Handler handler) {
    handler.setSuccessor(null);
    if (head == null) {
      head = handler;
      tail = handler;
      return;
    }
    tail.setSuccessor(handler);
    tail = handler;
  }

  public void handle() {
    if (head != null) {
      head.handle();
    }
  }
}
