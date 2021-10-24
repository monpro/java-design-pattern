package com.monpro.designpattern.behavior.chain.list;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WritingToDynamoHandler implements IHandler {
  @Override
  public boolean handle() {
    log.info("WRITING TO DYNAMO HANDLER");
    return false;
  }
}
