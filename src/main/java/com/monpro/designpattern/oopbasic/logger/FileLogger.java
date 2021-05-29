package com.monpro.designpattern.oopbasic.logger;

import java.io.IOException;
import java.io.Writer;
import java.util.logging.Level;

public class FileLogger extends Logger {

  private Writer fileWriter;

  public FileLogger(String name, boolean enabled, Level minLevel, Writer fileWriter) {
    super(name, enabled, minLevel);
    this.fileWriter = fileWriter;
  }

  @Override
  public void logMsg(Level level, String msg) {

    try {
      fileWriter.write(String.format("%s: %s", level, msg));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
