package com.monpro.designpattern.createobject;

import org.junit.Test;
import org.redisson.api.RLock;

import static org.junit.Assert.assertNotNull;

public class DistributedLockTest {

  @Test
  public void GivenDistributedLock_When_GetLock_Then_GetRedissonLock() {
    RLock lock = DistributedLock.getInstance().getDistributedLock("lock");
    assertNotNull(lock);
  }
}
