package com.monpro.designpattern.oopbasic;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
public class Wallet {
  private String id;
  private long createTime;
  private BigDecimal balance;
  private long lastModifiedTime;

  public Wallet() {
    this.id = UUID.randomUUID().toString();
    this.createTime = System.currentTimeMillis();
    this.balance = BigDecimal.ZERO;
    this.lastModifiedTime = this.createTime;
  }

  public void increaseBalance(BigDecimal amount) {
    if (amount.compareTo(BigDecimal.ZERO) < 0) {
      throw new IllegalArgumentException("Increase amount should not be negative");
    }
    this.balance = this.balance.add(amount);
    this.lastModifiedTime = System.currentTimeMillis();
  }

  public void decreaseBalance(BigDecimal amount) {
    if (amount.compareTo(BigDecimal.ZERO) < 0) {
      throw new IllegalArgumentException("Decrease amount should not be negative");
    }

    if (amount.compareTo(this.balance) > 0) {
      throw new IllegalArgumentException(
          "Decrease amount should not be larger than current balance");
    }
    this.balance = this.balance.subtract(amount);
    this.lastModifiedTime = System.currentTimeMillis();
  }

  public static void main(String[] args) {
    BigDecimal val = new BigDecimal(0);
    val = val.add(BigDecimal.valueOf(12));
    System.out.println(val);
  }
}
