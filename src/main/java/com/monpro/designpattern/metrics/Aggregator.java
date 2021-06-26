package com.monpro.designpattern.metrics;

import java.util.List;

public class Aggregator {

  public static RequestStats aggregate(List<RequestInfo> requestInfoList, long durationInMills) {
    double maxResponseTime = Double.MIN_VALUE;
    double minResponseTime = Double.MAX_VALUE;
    double avgResponseTime = -1;
    double p99ResponseTime = -1;
    double p999ResponseTime = -1;
    double sumResponseTime = 0;
    long requestCount = 0;

    for (RequestInfo requestInfo : requestInfoList) {
      requestCount += 1;
      double responseTime = requestInfo.getResponseTime();

      if (maxResponseTime < responseTime) {
        maxResponseTime = responseTime;
      }
      if (minResponseTime > responseTime) {
        minResponseTime = responseTime;
      }
      sumResponseTime += responseTime;
    }
    if (requestCount != 0) {
      avgResponseTime += sumResponseTime / requestCount;
    }

    long tps = requestCount / durationInMills * 1000;

    requestInfoList.sort((r1, r2) -> (int) (r1.getResponseTime() - r2.getResponseTime()));

    int idx999 = (int) (requestCount * 0.999);
    int idx99 = (int) (requestCount * 0.99);
    if (requestCount != 0) {
      p999ResponseTime += requestInfoList.get(idx999).getResponseTime();
      p99ResponseTime += requestInfoList.get(idx99).getResponseTime();
    }

    return RequestStats.builder()
        .maxResponseTime(maxResponseTime)
        .minResponseTime(minResponseTime)
        .avgResponseTime(avgResponseTime)
        .p99ResponseTime(p99ResponseTime)
        .p999ResponseTime(p999ResponseTime)
        .tps(tps)
        .count(requestCount)
        .build();
  }
}
