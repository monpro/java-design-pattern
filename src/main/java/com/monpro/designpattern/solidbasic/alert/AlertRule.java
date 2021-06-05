package com.monpro.designpattern.solidbasic.alert;

public interface AlertRule {

  RuleStateInfo getMatchedRule(String api);
}
