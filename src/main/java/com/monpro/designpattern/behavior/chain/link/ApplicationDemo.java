package com.monpro.designpattern.behavior.chain.link;

import com.monpro.designpattern.behavior.chain.link.AuthHandler;
import com.monpro.designpattern.behavior.chain.link.HandlerChain;
import com.monpro.designpattern.behavior.chain.link.HttpHandler;

public class ApplicationDemo {
  public static void main(String[] args) {
    final HandlerChain chain = new HandlerChain();
    chain.addHandler(new HttpHandler());
    chain.addHandler(new AuthHandler());
    chain.handle();
  }
}
