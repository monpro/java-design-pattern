package com.monpro.designpattern.oopbasic.logger;

import java.util.logging.Level;

public abstract class Logger {
  private String name;
  private boolean enabled;
  private Level minLevel;

  public Logger(String name, boolean enabled, Level minLevel) {
    this.name = name;
    this.enabled = enabled;
    this.minLevel = minLevel;
  }

  public void log(Level level, String msg) {
    if (enabled && level.intValue() >= minLevel.intValue()) logMsg(level, msg);
  }

  public abstract void logMsg(Level level, String msg);
}
