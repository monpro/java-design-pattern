package com.monpro.designpattern.oopbasic.logger;

import java.util.logging.Level;

public class MessageLogger extends Logger {

  private MessageSender messageSender;

  public MessageLogger(String name, boolean enabled, Level minLevel, MessageSender messageSender) {
    super(name, enabled, minLevel);
    this.messageSender = messageSender;
  }

  @Override
  public void logMsg(Level level, String msg) {
    messageSender.send(level, msg);
  }
}
