package com.monpro.designpattern.metrics;

import com.google.inject.Guice;
import com.google.inject.Injector;


public class MetricsService {

  public static void main(String[] args) {
    RequestInfo requestInfo = new RequestInfo("register", 2, System.currentTimeMillis());
    Injector injector = Guice.createInjector(new MetricsModule());
    MetricsCollector metricsCollector = injector.getInstance(MetricsCollector.class);
    metricsCollector.recordRequest(requestInfo);

  }
}
