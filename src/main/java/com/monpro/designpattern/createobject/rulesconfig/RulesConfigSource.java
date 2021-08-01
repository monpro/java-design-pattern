package com.monpro.designpattern.createobject.rulesconfig;

import static com.google.common.io.Files.getFileExtension;

public class RulesConfigSource {
  public RuleConfig load(String configPath) throws InvalidRuleConfigExpection {
    final String configExtension = getFileExtension(configPath);
//    RuleConfigParser parser = RuleConfigParserFactory.createParser(configExtension);
    IRuleConfigParserFactory parserFactory = RuleConfigParserFactoryMap.getParserFactory(configExtension);
    if (parserFactory == null) {
      throw new InvalidRuleConfigExpection("Rule Config file format is not supported", configExtension);
    }

    final String configText = getConfigText();
    return parserFactory.createParser().parse(configText);
  }

  private String getConfigText() {
    // TODO: add logic of getConfigText
    return "";
  }
}
