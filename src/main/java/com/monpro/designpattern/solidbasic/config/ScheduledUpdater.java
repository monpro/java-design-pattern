package com.monpro.designpattern.solidbasic.config;

import lombok.AllArgsConstructor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
public class ScheduledUpdater {
  private final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
  private long delayInSeconds;
  private long periodInSeconds;
  private Updater updater;

  public void run() {
    executorService.scheduleAtFixedRate(() -> updater.update(), this.delayInSeconds, this.periodInSeconds, TimeUnit.SECONDS);
  }

}
