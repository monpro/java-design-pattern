package com.monpro.designpattern.idgenerator;

import lombok.extern.slf4j.Slf4j;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

@Slf4j
public class IdGenerator {
  public static String generate() {
    String id = "";
    try {
      String localHostName = InetAddress.getLocalHost().getHostName();
      final String[] tokens = localHostName.split("\\.");
      if (tokens.length > 0) {
        localHostName = tokens[tokens.length - 1];
      }

      char[] randomChar = new char[8];
      int count = 0;
      Random random = new Random();
      while (count < 8) {
        int randomAsc = random.nextInt(122);
        if (randomAsc >= 48 && randomAsc <= 57) {
          randomChar[count] = (char) ('0' + (randomAsc - 48));
          count += 1;
        } else if (randomAsc >= 65 && randomAsc <= 90) {
          randomChar[count] = (char) ('0' + (randomAsc - 48));
          count += 1;
        } else if (randomAsc >= 97) {
          randomChar[count] = (char) ('0' + (randomAsc - 97));
          count += 1;
        }
      }
      id =
          String.format(
              "%s-%d-%s", localHostName, System.currentTimeMillis(), new String(randomChar));
    } catch (UnknownHostException e) {
      log.error("Unable to get hostName");
    }
    return id;
  }
}
