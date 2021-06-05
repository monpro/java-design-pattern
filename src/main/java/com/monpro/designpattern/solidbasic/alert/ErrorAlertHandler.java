package com.monpro.designpattern.solidbasic.alert;

public class ErrorAlertHandler extends AlertHandler {

  public ErrorAlertHandler(AlertRule alertRule, Notification notification) {
    super(alertRule, notification);
  }

  @Override
  public void check(ApiStateInfo apiStateInfo) {
    if (apiStateInfo.getErrorCount() > alertRule.getMatchedRule(apiStateInfo.getApi()).getMaxErrorCount()) {
      notification.notify("Error Alert");
    }
  }
}
