package com.monpro.designpattern.metrics;

import com.google.gson.Gson;
import com.google.inject.Inject;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class ConsoleReporter {

  private static final ScheduledExecutorService scheduledExecutorService =
      Executors.newSingleThreadScheduledExecutor();
  private static final Gson gson = new Gson();

  private final MetricsStorage metricsStorage;

  @Inject
  public ConsoleReporter(MetricsStorage metricsStorage) {
    this.metricsStorage = metricsStorage;
  }

  public void startScheduledReport(long periodInMills, long durationInMills) {
    scheduledExecutorService.scheduleAtFixedRate(
        () -> {
          final long endTimeInMills = System.currentTimeMillis();
          final long startTimeInMills = endTimeInMills - durationInMills;
          final Map<String, RequestStats> stats = MetricHelper.getCalculateStats(metricsStorage, durationInMills, endTimeInMills);
          log.info("Start time: {}, End time: {}", startTimeInMills, endTimeInMills);
          log.info(gson.toJson(stats));
        },
        0,
        periodInMills,
        TimeUnit.MILLISECONDS);
  }
}
