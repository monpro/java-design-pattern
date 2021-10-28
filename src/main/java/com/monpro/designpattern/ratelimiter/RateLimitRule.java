package com.monpro.designpattern.ratelimiter;

public class RateLimitRule {
  public RateLimitRule(final RuleConfig ruleConfig) {
  }

  public ApiLimit getLimit(final String appId, final String api) {
    return new ApiLimit();
  }
}
