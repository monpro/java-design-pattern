package com.monpro.designpattern.metrics;

import com.google.inject.AbstractModule;

public class MetricsModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(MetricsStorage.class).to(MysqlMetricsStorage.class);
  }

}
