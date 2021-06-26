package com.monpro.designpattern.metrics;

import java.util.List;
import java.util.Map;

public interface MetricsStorage {
  void saveRequestInfo(RequestInfo requestInfo);

  List<RequestInfo> getRequestInfo(String apiName, long startTimeInMills, long endTimeInMills);

  Map<String, List<RequestInfo>> getRequestInfos(long startTimeInMills, long endTimeInMills);
}
