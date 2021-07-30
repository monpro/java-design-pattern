package com.monpro.designpattern.createobject;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.Assert.assertEquals;

public class IdGeneratorThreadUniqueTest {

  @Test
  public void Given_TwoThreads_When_CallGetIdOnce_Then_GetSameId() throws InterruptedException {
    final int numOfThreads = 2;
    final ExecutorService service = Executors.newFixedThreadPool(numOfThreads);
    final CountDownLatch latch = new CountDownLatch(numOfThreads);
    for (int i = 0; i < numOfThreads; i++) {
      service.execute(
          () -> {
            assertEquals(IdGeneratorThreadUnique.getInstance().getId(), 1);
            latch.countDown();
          });
    }
    latch.await();
  }
}
