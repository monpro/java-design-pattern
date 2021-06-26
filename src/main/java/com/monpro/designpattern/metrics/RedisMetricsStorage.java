package com.monpro.designpattern.metrics;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

@Slf4j
public class RedisMetricsStorage implements MetricsStorage {
  private final Gson gson = new Gson();
  @Override
  public void saveRequestInfo(RequestInfo requestInfo) {
    log.info("trying to save requestInfo into Redis {}", gson.toJson(requestInfo));
  }

  @Override
  public List<RequestInfo> getRequestInfo(String apiName, long startTimeInMills, long endTimeInMills) {
    return null;
  }

  @Override
  public Map<String, List<RequestInfo>> getRequestInfos(long startTimeInMills, long endTimeInMills) {
    return null;
  }
}
