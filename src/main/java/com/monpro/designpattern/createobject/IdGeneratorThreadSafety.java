package com.monpro.designpattern.createobject;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class IdGeneratorThreadSafety {
  private AtomicLong id = new AtomicLong(0);

  private static final ConcurrentHashMap<Long, IdGeneratorThreadSafety> instances
      = new ConcurrentHashMap<>();

  private IdGeneratorThreadSafety() {}

  public static IdGeneratorThreadSafety getInstance() {
    Long currentThreadId = Thread.currentThread().getId();
    instances.putIfAbsent(currentThreadId, new IdGeneratorThreadSafety());
    return instances.get(currentThreadId);
  }

  public long getId() {
    return id.incrementAndGet();
  }

}
