package com.monpro.designpattern.solidbasic.alert;


public class TpsAlertHandler extends AlertHandler {
  public TpsAlertHandler(AlertRule alertRule, Notification notification) {
    super(alertRule, notification);
  }

  @Override
  public void check(ApiStateInfo apiStateInfo) {
    long tps = apiStateInfo.getRequestCount() / apiStateInfo.getDurationSeconds();
    if (tps > alertRule.getMatchedRule(apiStateInfo.getApi()).getMaxTps()) {
      notification.notify("TPS Alert");
    }
  }
}
