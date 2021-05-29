package com.monpro.designpattern.oopbasic;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class WalletTest {

  private Wallet wallet;

  @Before
  public void init() {
    wallet = new Wallet();
  }

  @Test
  public void When_WalletInit_Then_Get_Correct_Variables() {

    assertEquals(wallet.getBalance(), BigDecimal.ZERO);
    assertEquals(wallet.getId().length(), 36);
    assertEquals(wallet.getCreateTime(), wallet.getLastModifiedTime());
  }

  @Test(expected = IllegalArgumentException.class)
  public void When_DecreaseNegativeBalance_Then_Throw_Exception() {

    wallet.decreaseBalance(BigDecimal.valueOf(-1));
  }

  @Test(expected = IllegalArgumentException.class)
  public void When_DecreaseBalanceLargerThanCurrentOne_Then_Throw_Exception() {

    wallet.increaseBalance(BigDecimal.valueOf(100));
    wallet.decreaseBalance(BigDecimal.valueOf(101));
  }

  @Test(expected = IllegalArgumentException.class)
  public void When_IncreaseNegativeBalance_Then_Throw_Exception() {

    wallet.increaseBalance(BigDecimal.valueOf(-1));
  }

  @Test
  public void When_IncreaseBalance_Then_Get_Expected_Value() {

    wallet.increaseBalance(BigDecimal.valueOf(100));

    assertEquals(wallet.getBalance(), BigDecimal.valueOf(100));
  }

  @Test
  public void When_DecreaseBalance_Then_Get_Expected_Value() {

    wallet.increaseBalance(BigDecimal.valueOf(100));
    wallet.decreaseBalance(BigDecimal.valueOf(50));

    assertEquals(wallet.getBalance(), BigDecimal.valueOf(50));
  }
}
