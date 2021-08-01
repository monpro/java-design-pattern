package com.monpro.designpattern.createobject.rulesconfig;

public class XmlRuleConfigParserFactory implements IRuleConfigParserFactory {
  @Override
  public RuleConfigParser createParser() {
    return new XmlRuleConfigParser();
  }
}
