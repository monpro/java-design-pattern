package com.monpro.designpattern.metrics;

import com.google.inject.Guice;
import com.google.inject.Injector;

import java.util.concurrent.TimeUnit;

public class MetricsService {

  public static void main(String[] args) throws InterruptedException {
    Injector injector = Guice.createInjector(new Metrics());
    UserExampleController userExampleController = injector.getInstance(UserExampleController.class);
    userExampleController.setMetricsReportAttributes(2, TimeUnit.SECONDS);
    userExampleController.register();
  }
}
