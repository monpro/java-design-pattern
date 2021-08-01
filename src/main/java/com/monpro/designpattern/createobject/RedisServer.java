package com.monpro.designpattern.createobject;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
public class RedisServer {

  private final long serverNumber;
  private final String serverAddress;

  private static final int SERVER_COUNT = 2;
  private static final Map<Long, RedisServer> serverInstance = new HashMap<>();

  static {
    serverInstance.putIfAbsent(1L, new RedisServer(1L, "url1L:8080"));
    serverInstance.putIfAbsent(2L, new RedisServer(2L, "url2L:8080"));
  }

  public RedisServer getInstance(long serverNumber) {
    return serverInstance.get(serverNumber);
  }

}
