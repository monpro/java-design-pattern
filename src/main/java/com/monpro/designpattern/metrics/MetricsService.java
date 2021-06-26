package com.monpro.designpattern.metrics;

import com.google.inject.Guice;
import com.google.inject.Injector;


public class MetricsService {

  public static void main(String[] args) {
      MetricsStorage metricsStorage = new RedisMetricsStorage();
      ConsoleReporter consoleReporter = new ConsoleReporter(metricsStorage);
      consoleReporter.startScheduledReport(2000, 2000);

      MetricsCollector metricsCollector = new MetricsCollector(metricsStorage);
      metricsCollector.recordRequest(new RequestInfo("register", 11, 111));
      metricsCollector.recordRequest(new RequestInfo("register", 22, 222));

      try {
        Thread.sleep(100000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
  }
}
