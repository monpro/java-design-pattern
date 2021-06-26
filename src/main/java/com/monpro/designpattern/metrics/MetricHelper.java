package com.monpro.designpattern.metrics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MetricHelper {
  public static Map<String, RequestStats> getCalculateStats(MetricsStorage metricsStorage, long durationInMills, long endTimeInMills) {
    final long startTimeInMills = endTimeInMills - durationInMills;
    final Map<String, List<RequestInfo>> requestInfos =
        metricsStorage.getRequestInfos(startTimeInMills, endTimeInMills);
    final Map<String, RequestStats> stats = new HashMap<>();

    for (Map.Entry<String, List<RequestInfo>> entry : requestInfos.entrySet()) {
      final String apiName = entry.getKey();
      final List<RequestInfo> apiRequestInfoList = entry.getValue();

      final RequestStats requestStats =
          Aggregator.aggregate(apiRequestInfoList, durationInMills);
      stats.put(apiName, requestStats);
    }
    return stats;
  }

}
