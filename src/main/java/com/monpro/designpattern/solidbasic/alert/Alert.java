package com.monpro.designpattern.solidbasic.alert;

import java.util.ArrayList;
import java.util.List;

public class Alert {

  private final List<AlertHandler> alertHandlers = new ArrayList<>();

  protected void addAlertHandler(AlertHandler alertHandler) {
    this.alertHandlers.add(alertHandler);
  }

  public void check(ApiStateInfo apiStateInfo) {
    for (AlertHandler alertHandler : alertHandlers) {
      alertHandler.check(apiStateInfo);
    }
  }
}
