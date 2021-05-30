package com.monpro.designpattern.oopbasic.apiauthenticator;

public interface ApiAuthenticator {
  void auth(String url);

  void auth(ApiRequest apiRequest);
}
