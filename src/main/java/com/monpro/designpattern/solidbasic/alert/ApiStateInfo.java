package com.monpro.designpattern.solidbasic.alert;


import lombok.Data;

@Data
public class ApiStateInfo {
  private String api;
  private long requestCount;
  private long errorCount;
  private long durationSeconds;
  private long timeoutCount;
}
