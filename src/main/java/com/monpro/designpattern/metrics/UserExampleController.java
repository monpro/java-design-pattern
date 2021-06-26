package com.monpro.designpattern.metrics;

import com.google.inject.Inject;
import lombok.AllArgsConstructor;

import java.util.concurrent.TimeUnit;

public class UserExampleController {

  private Metrics metrics;

  @Inject
  public UserExampleController(Metrics metrics) {
    this.metrics = metrics;
  }

  public void setMetricsReportAttributes(long interval, TimeUnit timeUnit) {
    this.metrics.startReportMetrics(interval, timeUnit);
  }

  public void register() throws InterruptedException {
    long startTimeStamp = System.currentTimeMillis();
    metrics.recordTimeStamp("register", startTimeStamp);

    Thread.sleep(5);
    metrics.recordResponseTimes("register", System.currentTimeMillis() - startTimeStamp);
  }

  public void login() throws InterruptedException {
    long startTimeStamp = System.currentTimeMillis();
    metrics.recordTimeStamp("login", startTimeStamp);

    Thread.sleep(5);
    metrics.recordResponseTimes("login", System.currentTimeMillis() - startTimeStamp);
  }

}
