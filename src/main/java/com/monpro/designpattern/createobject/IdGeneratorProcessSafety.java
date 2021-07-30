package com.monpro.designpattern.createobject;

import com.monpro.designpattern.oopbasic.filestorage.AwsFileStorage;
import com.monpro.designpattern.oopbasic.filestorage.IFileStorage;
import org.redisson.api.RLock;

import java.util.concurrent.atomic.AtomicLong;

public class IdGeneratorProcessSafety {

  private AtomicLong id = new AtomicLong();
  private static IdGeneratorProcessSafety instance;
  private static IFileStorage fileStorage = new AwsFileStorage();
  private static RLock lock = DistributedLock.getInstance().getDistributedLock("testLock");

  private IdGeneratorProcessSafety() {}

  public static IdGeneratorProcessSafety getInstance() {
    if (instance == null) {
      lock.lock();
      instance = fileStorage.load(IdGeneratorProcessSafety.class);
    }
    return instance;
  }

  public void freeInstance() {
    fileStorage.save(this, IdGeneratorProcessSafety.class);
    instance = null;
    lock.unlock();
  }

  public long getId() {
    return id.incrementAndGet();
  }
}
