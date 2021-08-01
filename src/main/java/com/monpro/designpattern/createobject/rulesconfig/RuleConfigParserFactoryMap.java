package com.monpro.designpattern.createobject.rulesconfig;

import java.util.HashMap;
import java.util.Map;

public class RuleConfigParserFactoryMap {

  private static final Map<String, IRuleConfigParserFactory> factories = new HashMap<>();

  static {
    factories.put("json", new JsonRuleConfigParserFactory());
    factories.put("xml", new XmlRuleConfigParserFactory());
    factories.put("yaml", new YamlRuleConfigParserFactory());
  }

  public static IRuleConfigParserFactory getParserFactory(final String factoryType) {
    if (factoryType == null || factoryType.isEmpty()) {
      throw new IllegalArgumentException("factoryType is invalid");
    }
    return factories.get(factoryType);
  }
}
