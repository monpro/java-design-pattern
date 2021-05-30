package com.monpro.designpattern.oopbasic.apiauthenticator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class ApiRequest {

  private String baseUrl;
  private String token;
  private String appId;
  private long timeStamp;

  public static ApiRequest createFromUrl(String url) {
    return null;
  }
}
