package com.monpro.designpattern.idgenerator;

import com.google.common.annotations.VisibleForTesting;
import lombok.extern.slf4j.Slf4j;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Optional;
import java.util.Random;

@Slf4j
public class RandomIdGenerator implements LogTraceIdGenerator {

  @Override
  public String generate() throws IdGenerationFailureException {
    String localHostName;
    try {
      localHostName = getLastFieldOfHostName().orElse("Default Host name");
    } catch (UnknownHostException e) {
      throw new IdGenerationFailureException("host name is Empty");
    }
    final String randomString = generateRandomAlpha(8);
    return String.format("%s-%d-%s", localHostName, System.currentTimeMillis(), randomString);
  }

  private Optional<String> getLastFieldOfHostName() throws UnknownHostException {
      final String localHostName = InetAddress.getLocalHost().getHostName();
      return getLastSubstringSplitByDot(localHostName);
  }

  @VisibleForTesting
  protected Optional<String> getLastSubstringSplitByDot(String localHostName) {
    if (localHostName == null) {
      return Optional.empty();
    }
    final String[] tokens = localHostName.split("\\.");
    return Optional.of(tokens[tokens.length - 1]);
  }


  @VisibleForTesting
  protected String generateRandomAlpha(final int length) {
    if (length <= 0) {
      throw new IllegalArgumentException("length should be positive");
    }
    final char[] randomChar = new char[length];
    final int maxAsc = 'z';
    int count = 0;
    Random random = new Random();
    while (count < length) {
      final int randomAsc = random.nextInt(maxAsc);
      final boolean isDigit = randomAsc >= '0' && randomAsc <= '9';
      final boolean idUpperCase = randomAsc >= 'A' && randomAsc <= 'Z';
      final boolean isLowerCase = randomAsc >= 'a';
      if (isDigit || idUpperCase || isLowerCase) {
        randomChar[count] = (char) (randomAsc);
        count += 1;
      }
    }
    return String.valueOf(randomChar);
  }
}
