package com.monpro.designpattern.metrics;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static java.util.Collections.max;
import static java.util.Collections.min;

public class Metrics {

  private final Map<String, List<Double>> responseTimes = new HashMap<>();
  private final Map<String, List<Double>> timestamps = new HashMap<>();
  private final ScheduledExecutorService executorService =
      Executors.newSingleThreadScheduledExecutor();

  /**
   * record response time for given apiName
   *
   * @param apiName the name of api.
   * @param responseTime the response time of calling the api.
   */
  public void recordResponseTimes(String apiName, double responseTime) {
    responseTimes.putIfAbsent(apiName, new ArrayList<>());
    responseTimes.get(apiName).add(responseTime);
  }

  /**
   * record timestamp time for given apiName
   *
   * @param apiName the name of api.
   * @param timeStamp the timestamp of calling the api.
   */
  public void recordTimeStamp(String apiName, double timeStamp) {
    timestamps.putIfAbsent(apiName, new ArrayList<>());
    timestamps.get(apiName).add(timeStamp);
  }

  /**
   * report the metrics at fix rate.
   *
   * @param interval the interval time of reporting the metrics.
   * @param timeUnit the timeUnit of the interval.
   */
  public void startReportMetrics(long interval, TimeUnit timeUnit) {
    executorService.scheduleAtFixedRate(
        () -> {
          final Gson gson = new Gson();
          final Map<String, Map<String, Double>> stats = new HashMap<>();

          for (Map.Entry<String, List<Double>> entry : responseTimes.entrySet()) {
            final String apiName = entry.getKey();
            final List<Double> apiResponseTimes = entry.getValue();
            stats.putIfAbsent(apiName, new HashMap<>());
            stats.get(apiName).put("max", max(apiResponseTimes));
            stats.get(apiName).put("min", min(apiResponseTimes));
          }

          for (Map.Entry<String, List<Double>> entry : timestamps.entrySet()) {
            final String apiName = entry.getKey();
            final List<Double> apiTimeStamps = entry.getValue();
            stats.putIfAbsent(apiName, new HashMap<>());
            stats.get(apiName).put("count", (double) apiTimeStamps.size());
          }
          System.out.println(gson.toJson(stats));
        },
        0,
        interval,
        timeUnit);
  }
}
