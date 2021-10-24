package com.monpro.designpattern.behavior.chain.list;

import java.util.ArrayList;
import java.util.List;

public class HandlerChain {
  private List<IHandler> handlers = new ArrayList<>();

  public void addHandler(final IHandler handler) {
    this.handlers.add(handler);
  }

  public void handle() {
    for (final IHandler handler: handlers) {
      final boolean handled = handler.handle();
      if (handled) {
        break;
      }
    }
  }
}
