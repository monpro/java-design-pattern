package com.monpro.designpattern.solidbasic.alert;

import lombok.Data;

@Data
public class RuleStateInfo {
  private long maxTps;
  private long maxErrorCount;

}
