package com.monpro.designpattern.createobject;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

public class DistributedLock {
  private static final Config config = new Config();
  private static DistributedLock instance = null;

  private RedissonClient redissonClient;

  private DistributedLock() {
    config.useSingleServer().setAddress("redis://127.0.0.1:6379");

    // use this if we have cluster servers
//    config.useClusterServers().addNodeAddress("redis://127.0.0.1:6379");

    redissonClient = Redisson.create(config);

  }

  public static DistributedLock getInstance() {
    if (instance == null) {
      instance = new DistributedLock();
    }
    return instance;
  }

  public RLock getDistributedLock(String name) {
    return redissonClient.getLock(name);
  }

}
