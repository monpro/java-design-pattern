package com.monpro.designpattern.metrics;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class RequestInfo {

  private String apiName;
  private double responseTime;
  private long timestamp;
}
