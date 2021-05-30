package com.monpro.designpattern.oopbasic.apiauthenticator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthToken {

  private static final long DEFAULT_EXPIRED_TIME_INTERVAL = 1 * 600 * 1000;
  private String token;
  private long createTime;
  private long expiredTimeInterval = DEFAULT_EXPIRED_TIME_INTERVAL;

  public AuthToken(String token, long createTime) {
    this.token = token;
    this.createTime = createTime;
  }

  public static AuthToken create(String baseUrl, long createTime, Map<String, String> params) {
    return null;
  }

  public static AuthToken generate(
      String originalUrl, String appId, String password, long timeStamp) {
    return null;
  }

  public String getToken() {
    return token;
  }

  public boolean isExpired() {
    return true;
  }

  public boolean match(AuthToken authToken) {
    return true;
  }
}
