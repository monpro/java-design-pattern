package com.monpro.designpattern.behavior.chain.list;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MetricHandler implements IHandler {
  @Override
  public boolean handle() {
    log.info("METRIC HANDLER");
    return true;
  }
}
