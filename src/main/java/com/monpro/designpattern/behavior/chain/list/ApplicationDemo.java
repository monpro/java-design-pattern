package com.monpro.designpattern.behavior.chain.list;

public class ApplicationDemo {
  public static void main(String[] args) {
    final HandlerChain chain = new HandlerChain();
    chain.addHandler(new MetricHandler());
    chain.addHandler(new WritingToDynamoHandler());
    chain.handle();
  }
}
