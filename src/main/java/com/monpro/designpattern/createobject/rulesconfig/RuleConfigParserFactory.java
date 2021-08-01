package com.monpro.designpattern.createobject.rulesconfig;

import java.util.HashMap;
import java.util.Map;

public class RuleConfigParserFactory {
  private static final Map<String, RuleConfigParser> parsers = new HashMap<>();

  static {
    parsers.put("json", new JsonRuleConfigParser());
    parsers.put("xml", new XmlRuleConfigParser());
    parsers.put("yaml", new YamlRuleConfigParser());
  }

  public static RuleConfigParser createParser(String configExtension) {
    if (configExtension == null || configExtension.isEmpty()) {
      throw new IllegalArgumentException("Invalid configExtension");
    }
    return parsers.get(configExtension.toLowerCase());
  }
}
