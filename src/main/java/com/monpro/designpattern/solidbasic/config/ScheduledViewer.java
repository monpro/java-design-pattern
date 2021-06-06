package com.monpro.designpattern.solidbasic.config;

import lombok.AllArgsConstructor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
public class ScheduledViewer {
  private final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
  private long delayInSeconds;
  private long periodInSeconds;
  private Viewer viewer;

  public void run() {
    executorService.scheduleAtFixedRate(() -> viewer.outputHtmlText(), this.delayInSeconds, this.periodInSeconds, TimeUnit.SECONDS);
  }
}
