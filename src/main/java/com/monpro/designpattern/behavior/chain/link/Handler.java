package com.monpro.designpattern.behavior.chain.link;

public abstract class Handler {
  protected Handler successor = null;

  public void setSuccessor(Handler successor) {
    this.successor = successor;
  }

  public final void handle() {
    boolean handled = doHandle();
    if (!handled && successor != null) {
      successor.handle();
    }
  }

  protected abstract boolean doHandle();

}
