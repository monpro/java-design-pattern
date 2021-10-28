package com.monpro.designpattern.ratelimiter;

import lombok.extern.slf4j.Slf4j;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class RateLimiter {
  private ConcurrentHashMap<String, RateLimitAlg> counters = new ConcurrentHashMap<>();
  private RateLimitRule rateLimitRule;

  public RateLimiter() {
    RuleConfig ruleConfig = null;
    try(final InputStream inputStream = this.getClass().getResourceAsStream("/ratelimiter-rule.yaml")) {

      if (inputStream != null) {
        final Yaml yaml = new Yaml();
        ruleConfig = yaml.loadAs(inputStream, RuleConfig.class);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    rateLimitRule = new RateLimitRule(ruleConfig);
  }
}
