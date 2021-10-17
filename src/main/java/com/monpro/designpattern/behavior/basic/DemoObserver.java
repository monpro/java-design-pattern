package com.monpro.designpattern.behavior.basic;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DemoObserver implements Observer {
  private String observerName;

  public DemoObserver(String observerName) {
    this.observerName = observerName;
  }

  @Override
  public void update(Message message) {
    // TODO: add logic when executing update given message
    log.info("update with message : {} for observer : {}", message.getContent(), this.observerName);
  }
}
