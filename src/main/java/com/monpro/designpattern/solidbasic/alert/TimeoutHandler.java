package com.monpro.designpattern.solidbasic.alert;

public class TimeoutHandler extends AlertHandler {
  public TimeoutHandler(AlertRule alertRule, Notification notification) {
    super(alertRule, notification);
  }

  @Override
  public void check(ApiStateInfo apiStateInfo) {
    final long timeoutTps = apiStateInfo.getTimeoutCount() / apiStateInfo.getDurationSeconds();
    if(timeoutTps > alertRule.getMatchedRule(apiStateInfo.getApi()).getMaxTimeoutTps()) {
      notification.notify("TIMEOUT");
    }
  }
}
