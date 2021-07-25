package com.monpro.designpattern.idgenerator;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class RandomIdGeneratorTest {

  final RandomIdGenerator idGenerator = new RandomIdGenerator();

  @Test
  public void Given_ValidHostName_Then_GetLastSubstring(){
    Optional<String> lastSubstringSplitByDot = idGenerator.getLastSubstringSplitByDot("A1.A2.A3");
    assertTrue(lastSubstringSplitByDot.isPresent());
    assertEquals(lastSubstringSplitByDot.get(), "A3");
  }

  @Test
  public void Given_HostNameWithoutDot_Then_GetOriginalString() {
    Optional<String> lastSubstringSplitByDot = idGenerator.getLastSubstringSplitByDot("A1A2A3");
    assertTrue(lastSubstringSplitByDot.isPresent());
    assertEquals(lastSubstringSplitByDot.get(), "A1A2A3");
  }

  @Test
  public void Given_NullHostName_Then_GetOptionalEmpty() {
    Optional<String> lastSubstringSplitByDot = idGenerator.getLastSubstringSplitByDot(null);
    assertFalse(lastSubstringSplitByDot.isPresent());
  }

  @Test
  public void GivenPositiveLength_When_GenerateRandomAlpha_GetRandomAlphaString() {
    final String randomString = idGenerator.generateRandomAlpha(8);
    assertNotNull(randomString);
    assertEquals(randomString.length(), 8);
    for(char ch: randomString.toCharArray()) {
      assertTrue(('0' < ch && ch < '9') || ('a' < ch && ch < 'z') || ('A' < ch && ch < 'Z'));
    }
  }
}
