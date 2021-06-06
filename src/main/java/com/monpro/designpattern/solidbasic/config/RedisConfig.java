package com.monpro.designpattern.solidbasic.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RedisConfig implements Updater, Viewer {
  private ConfigSource configSource;
  private String address;
  private int timeout;
  private int maxTotal;

  public void update() {
    // TODO: update member values from outside resources
  }

  @Override
  public String outputHtmlText() {
    return null;
  }

  @Override
  public Map<String, String> output() {
    return null;
  }
}
