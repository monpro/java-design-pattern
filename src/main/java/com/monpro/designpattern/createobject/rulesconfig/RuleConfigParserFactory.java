package com.monpro.designpattern.createobject.rulesconfig;

public class RuleConfigParserFactory {
  public static RuleConfigParser createParser(String configExtension) {
    RuleConfigParser ruleConfigParser = null;
    if("json".equalsIgnoreCase(configExtension)) {
      ruleConfigParser = new JsonRuleConfigParser();
    } else if ("xml".equalsIgnoreCase(configExtension)) {
      ruleConfigParser = new XmlRuleConfigParser();
    } else if("yaml".equalsIgnoreCase(configExtension)) {
      ruleConfigParser = new YamlRuleConfigParser();
    }
    return ruleConfigParser;
  }
}
