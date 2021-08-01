package com.monpro.designpattern.createobject.rulesconfig;

public class JsonRuleConfigParserFactory implements IRuleConfigParserFactory {

  @Override
  public RuleConfigParser createParser() {
    return new JsonRuleConfigParser();
  }
}
