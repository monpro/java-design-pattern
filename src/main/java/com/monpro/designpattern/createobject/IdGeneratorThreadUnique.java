package com.monpro.designpattern.createobject;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class IdGeneratorThreadUnique {
  private AtomicLong id = new AtomicLong(0);

  private static final ConcurrentHashMap<Long, IdGeneratorThreadUnique> instances
      = new ConcurrentHashMap<>();

  private IdGeneratorThreadUnique() {}

  public static IdGeneratorThreadUnique getInstance() {
    Long currentThreadId = Thread.currentThread().getId();
    instances.putIfAbsent(currentThreadId, new IdGeneratorThreadUnique());
    return instances.get(currentThreadId);
  }

  public long getId() {
    return id.incrementAndGet();
  }

}
