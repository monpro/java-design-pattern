package com.monpro.designpattern.solidbasic.config;

public class Main {
  private static final RedisConfig redisConfig = new RedisConfig();
  private static final MysqlConfig mysqlConfig = new MysqlConfig();
  public static void main(String[] args) {
    ScheduledUpdater redisUpdater = new ScheduledUpdater(600, 600, redisConfig);
    ScheduledViewer mysqlUpdater = new ScheduledViewer(600, 600, mysqlConfig);
    redisUpdater.run();
    mysqlUpdater.run();
  }
}
