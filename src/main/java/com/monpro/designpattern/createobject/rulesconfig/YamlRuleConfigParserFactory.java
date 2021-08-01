package com.monpro.designpattern.createobject.rulesconfig;

public class YamlRuleConfigParserFactory implements IRuleConfigParserFactory {
  @Override
  public RuleConfigParser createParser() {
    return new YamlRuleConfigParser();
  }
}
