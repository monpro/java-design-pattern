package com.monpro.designpattern.solidbasic.alert;


public abstract class AlertHandler {
  protected AlertRule alertRule;
  protected Notification notification;

  public AlertHandler(AlertRule alertRule, Notification notification) {
    this.alertRule = alertRule;
    this.notification = notification;
  }

  public abstract void check(ApiStateInfo apiStateInfo);
}
