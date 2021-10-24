package com.monpro.designpattern.behavior.chain;

public class ApplicationDemo {
  public static void main(String[] args) {
    final HandlerChain chain = new HandlerChain();
    chain.addHandler(new HttpHandler());
    chain.addHandler(new AuthHandler());
    chain.handle();
  }
}
