package com.monpro.designpattern.metrics;

import com.google.inject.Inject;
import org.apache.commons.lang3.StringUtils;

public class MetricsCollector {

  private MetricsStorage metricsStorage;

  @Inject
  public MetricsCollector(MetricsStorage metricsStorage) {
    this.metricsStorage = metricsStorage;
  }

  public void recordRequest(RequestInfo requestInfo) {
    if (requestInfo == null || StringUtils.isBlank(requestInfo.getApiName())) {
      return;
    }
    metricsStorage.saveRequestInfo(requestInfo);
  }
}
